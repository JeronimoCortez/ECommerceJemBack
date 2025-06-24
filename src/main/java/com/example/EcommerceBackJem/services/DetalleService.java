package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Detalle;
import com.example.EcommerceBackJem.entities.OrdenCompra;
import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.entities.dto.DetalleDTO;
import com.example.EcommerceBackJem.repositories.OrdenCompraRepository;
import com.example.EcommerceBackJem.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.DetalleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleService extends BaseService<Detalle, Long>{
    public DetalleService(BaseRepository<Detalle, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    DetalleRepository detalleRepository;

    @Autowired
    ProductoRepository productoRepository;
    public Detalle crearDetalle(DetalleDTO detalleDTO) {
        Producto producto = productoRepository.findById(detalleDTO.getIdProducto()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Detalle detalle = new Detalle();
        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setTalle(detalleDTO.getTalle());
        detalle.setOrdenCompra(null);
        detalle.setProducto(producto);
        detalleRepository.save(detalle);
        return detalle;
    }

    public List<Detalle> detallePorOrdenId(Long idOrden){
        List<Detalle> detallesBd = detalleRepository.findAll();

        List<Detalle> detallesFiltrados = detallesBd.stream().filter(d -> d.getOrdenCompra().getId().equals(idOrden)).collect(Collectors.toList());
        return detallesFiltrados;
    }
}
