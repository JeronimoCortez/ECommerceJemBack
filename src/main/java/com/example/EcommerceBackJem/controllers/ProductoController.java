package com.example.EcommerceBackJem.controllers;


import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.entities.dto.ProductoDTO;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;
import com.example.EcommerceBackJem.services.ProductoService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceBackJem.services.BaseService;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController extends BaseController<Producto, Long> {
    public ProductoController(BaseService<Producto, Long> service) {
        super(service);
    }

    @Autowired
    private ProductoService productoService;

    @PostMapping("/create")
    public ResponseEntity<Producto> createProducto(@RequestBody ProductoDTO productoDTO) throws Exception {
        Producto productoCreado = productoService.saveFromDTO(productoDTO);
        return ResponseEntity.ok(productoCreado);
    }

    @PatchMapping("/{idProducto}/addDiscount/{idDescuento}")
    public ResponseEntity<Producto> asignarDescuento(@PathVariable Long idProducto, @PathVariable Long idDescuento){
        Producto producto = productoService.asignarDescuento(idProducto, idDescuento);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/filtrarPorMarca/{marca}")
    public ResponseEntity<List<Producto>> filtroMarca(@PathVariable String marca){
        List<Producto> productos = productoService.filtrarPorMarca(marca);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/filtrarPorCategoria/{nombreCategoria}")
    public ResponseEntity<List<Producto>> filtroCategoria(@PathVariable String nombreCategoria){
        List<Producto> productos = productoService.filtrarPorCategoria(nombreCategoria);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/filtrarPorTalle/{talle}")
    public ResponseEntity<List<Producto>> filtroTalle(@PathVariable String talle){
        List<Producto> productos = productoService.filtrarPorTalle(talle);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/nuevos")
    public ResponseEntity<List<Producto>> getNuevos(){
        List<Producto> productos = productoService.getNuevos();
        return ResponseEntity.ok(productos);
    }
}
