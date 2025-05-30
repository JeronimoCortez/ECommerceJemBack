package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Detalle;
import com.example.EcommerceBackJem.entities.OrdenCompra;
import com.example.EcommerceBackJem.entities.Usuario;
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

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long>{
    public OrdenCompraService(BaseRepository<OrdenCompra, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    DetalleRepository detalleRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    OrdenCompraRepository ordenCompraRepository;

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
}
