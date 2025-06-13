package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Categoria;
import com.example.EcommerceBackJem.entities.Descuento;
import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.entities.Talle;
import com.example.EcommerceBackJem.entities.dto.ProductoDTO;
import com.example.EcommerceBackJem.repositories.*;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Producto saveFromDTO(ProductoDTO dto) throws Exception {
        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria()).orElseThrow(() -> new Exception("Categoria no encontrada"));
        System.out.println("Categoria" + categoria.getId());

        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .descripcion(dto.getDescripcion())
                .color(dto.getColor())
                .marca(dto.getMarca())
                .imagen(dto.getImagen())
                .genero(dto.getGenero())
                .categoria(categoria)
                .build();
        Producto productoGuardado = this.save(producto);


        List<Talle> talles = dto.getTalles().stream().map(productoDto -> {
            Talle talle = new Talle();
            talle.setTalle(productoDto.getTalle());
            talle.setStock(productoDto.getStock());
            talle.setProducto(productoGuardado);
            return talle;
        }).collect(Collectors.toList());


        talleRepository.saveAll(talles);

        productoGuardado.setTalles(talles);

        categoria.getProductos().add(productoGuardado);

        return productoGuardado;
    }

    public Producto asignarDescuento(Long idProducto, Long idDescuento){
            Producto producto = productoRepository.findById(idProducto)
                    .orElseThrow(() -> new RuntimeException("Producto no valido"));

            Descuento descuento = descuentoRepository.findById(idDescuento)
                    .orElseThrow(() -> new RuntimeException("Descuento no valido"));
            if ((producto.getPrecio() - (producto.getPrecio() * (descuento.getDescuento() / 100)) >= 0)){
                producto.setDescuento(descuento);
                return productoRepository.save(producto);
            }

            return producto;
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

    public List<Producto> getNuevos(){
        Pageable pageable = PageRequest.of(0, 4, Sort.by("id").descending());
        return productoRepository.findAll(pageable).getContent();
    }
}
