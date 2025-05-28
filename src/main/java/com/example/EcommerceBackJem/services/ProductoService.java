package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Descuento;
import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.repositories.CategoriaRepository;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService extends BaseService<Producto, Long>{
    public ProductoService(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DescuentoRepository descuentoRepository;

    public Producto asignarDescuento(Long idProducto, Long idDescuento){
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new RuntimeException("Producto no valido"));

            Descuento descuento = descuentoRepository.findById(idDescuento)
                    .orElseThrow(()-> new RuntimeException("Descuento no valido"));
            if ((producto.getPrecio() - descuento.getDescuento()) >= 0){
                producto.getDescuentos().add(descuento);
                return productoRepository.save(producto);
            }

            return producto;
    }


    public Producto eliminarImagen(Long idProducto){
        Optional<Producto> productoBd = productoRepository.findById(idProducto);

        if (!productoBd.isPresent()){
            return null;
        }

        productoBd.get().setImagen("");

        return productoRepository.save(productoBd.get());

    }
}
