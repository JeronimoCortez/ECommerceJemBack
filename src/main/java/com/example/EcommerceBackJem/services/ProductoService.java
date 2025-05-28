package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Categoria;
import com.example.EcommerceBackJem.entities.Descuento;
import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.entities.Talle;
import com.example.EcommerceBackJem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService extends BaseService<Producto, Long> {
    public ProductoService(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DescuentoRepository descuentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TalleRepository talleRepository;



    public Producto asignarDescuento(Long idProducto, Long idDescuento){
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new RuntimeException("Producto no valido"));

            Descuento descuento = descuentoRepository.findById(idDescuento)
                    .orElseThrow(() -> new RuntimeException("Descuento no valido"));
            if ((producto.getPrecio() - descuento.getDescuento()) >= 0){
                producto.getDescuentos().add(descuento);
                return productoRepository.save(producto);
            }

            return producto;
    }

    public Producto agregarCategoria(Long idProducto, Long idCategoria){
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no valido"));
        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoria no valida"));

        producto.getCategorias().add(categoria);

        return productoRepository.save(producto);
    }

    public List<Producto> filtrarPorMarca(String marca) {
        return productoRepository.findByMarca(marca);
    }

    public List<Producto> filtrarPorCategoria(String nombreCategoria){
        Categoria categoriaBd = categoriaRepository.findByNombre(nombreCategoria).orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        return categoriaBd.getProductos();
    }

    public List<Producto> filtrarPorTalle(String talle){
        List<Talle> tallesBd =  talleRepository.findByTalle(talle);
        List<Producto> productos = tallesBd.stream().map(Talle::getProducto).collect(Collectors.toList());
        return productos;
    }
}
