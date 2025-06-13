package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.*;
import com.example.EcommerceBackJem.entities.enums.Estado;
import com.example.EcommerceBackJem.repositories.DetalleRepository;
import com.example.EcommerceBackJem.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.OrdenCompraRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long> {
    public OrdenCompraService(BaseRepository<OrdenCompra, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    DetalleRepository detalleRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    OrdenCompraRepository ordenCompraRepository;
/*
    @Transactional
    public OrdenCompra generarOrdenCompra(List<Long> idDetalle, Long idUsuario) throws Exception{
        List<Detalle> detalles = new ArrayList<>();
        Double precioTotal = 0.0;
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new Exception("Usuario no encontrado"));

        for (Long id : idDetalle){
            Detalle detalle = detalleRepository.findById(id).orElseThrow(() -> new Exception("No se encontro el detalle"));
            detalles.add(detalle);
        }

        for (Detalle d : detalles){
            precioTotal += d.getProducto().getPrecio();
        }

        OrdenCompra ordenCompra = OrdenCompra.builder()
                .usuario(usuario)
                .detalles(detalles)
                .precioTotal(precioTotal)
                .fecha(LocalDate.from(LocalDate.now()))
                .estado(Estado.PENDIENTE)
                .build();

        return ordenCompraRepository.save(ordenCompra);
    }


 */
@Transactional
public OrdenCompra generarOrdenCompra(List<Long> idDetalle, Long idUsuario) throws Exception {
    List<Detalle> detalles = new ArrayList<>();
    Double precioTotal = 0.0;

    // Buscar el usuario
    Usuario usuario = usuarioRepository.findById(idUsuario)
            .orElseThrow(() -> new Exception("Usuario no encontrado"));

    // Buscar los detalles por ID
    for (Long id : idDetalle) {
        Detalle detalle = detalleRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró el detalle con ID " + id));
        detalles.add(detalle);
    }

    // Validar stock y calcular precio total
    for (Detalle d : detalles) {
        Producto producto = d.getProducto();

        // Buscar el talle correspondiente
        Optional<Talle> talleProducto = producto.getTalles()
                .stream()
                .filter(t -> t.getTalle().equalsIgnoreCase(d.getTalle()))
                .findFirst();

        if (talleProducto.isEmpty()) {
            throw new Exception("Talle " + d.getTalle() + " no encontrado para el producto " + producto.getNombre());
        }

        Talle talle = talleProducto.get();

        // Validar stock
        if (talle.getStock() < d.getCantidad()) {
            throw new Exception("Stock insuficiente para el producto " + producto.getNombre() +
                    " talle " + d.getTalle() + ". Disponible: " + talle.getStock());
        }

        // Descontar stock
        talle.setStock((int) (talle.getStock() - d.getCantidad()));

        // Calcular precio total (precio unitario * cantidad)
        precioTotal += producto.getPrecio() * d.getCantidad();
    }

    // Crear la orden
    OrdenCompra ordenCompra = OrdenCompra.builder()
            .usuario(usuario)
            .detalles(detalles)
            .precioTotal(precioTotal)
            .fecha(LocalDate.now())
            .estado(Estado.PENDIENTE)
            .build();

    // Establecer la relación inversa
    for (Detalle d : detalles) {
        d.setOrdenCompra(ordenCompra);
    }

    // Guardar la orden (y los detalles si tenés cascade)
    return ordenCompraRepository.save(ordenCompra);
}

}