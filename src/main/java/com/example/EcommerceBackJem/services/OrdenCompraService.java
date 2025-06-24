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

    Usuario usuario = usuarioRepository.findById(idUsuario)
            .orElseThrow(() -> new Exception("Usuario no encontrado"));

    for (Long id : idDetalle) {
        Detalle detalle = detalleRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró el detalle con ID " + id));
        detalles.add(detalle);
    }


    for (Detalle d : detalles) {
        Producto producto = d.getProducto();

        Optional<Talle> talleProducto = producto.getTalles()
                .stream()
                .filter(t -> t.getTalle().equalsIgnoreCase(d.getTalle()))
                .findFirst();

        if (talleProducto.isEmpty()) {
            throw new Exception("Talle " + d.getTalle() + " no encontrado para el producto " + producto.getNombre());
        }

        Talle talle = talleProducto.get();

        if (talle.getStock() < d.getCantidad()) {
            throw new Exception("Stock insuficiente para el producto " + producto.getNombre() +
                    " talle " + d.getTalle() + ". Disponible: " + talle.getStock());
        }


        talle.setStock((int) (talle.getStock() - d.getCantidad()));

        precioTotal += producto.getPrecio() * d.getCantidad();
    }

    OrdenCompra ordenCompra = OrdenCompra.builder()
            .usuario(usuario)
            .detalles(detalles)
            .precioTotal(precioTotal)
            .fecha(LocalDate.now())
            .estado(Estado.PENDIENTE)
            .build();

    for (Detalle d : detalles) {
        d.setOrdenCompra(ordenCompra);
    }
    
    return ordenCompraRepository.save(ordenCompra);
}

public OrdenCompra modificarEstado(Long id, Estado estado) {
    OrdenCompra ordenCompra = ordenCompraRepository.findById(id).orElseThrow(() -> new RuntimeException("Orden de compra no encotrada"));
    ordenCompra.setEstado(estado);
    ordenCompraRepository.save(ordenCompra);
    return ordenCompra;
}

    public List<OrdenCompra> ordenesPorUsuario(Long idUsuario) {
        List<OrdenCompra> ordenes = ordenCompraRepository.findAllByUsuarioId(idUsuario);
        return ordenes;
    }

}