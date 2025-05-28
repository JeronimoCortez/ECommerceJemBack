package com.example.EcommerceBackJem.controllers;


import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;
import com.example.EcommerceBackJem.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceBackJem.repositories.ProductoRepository;
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

    @PatchMapping("/{idProducto}/addDiscount/{idDescuento}")
    public ResponseEntity<Producto> asignarDescuento(@PathVariable Long idProducto, @PathVariable Long idDescuento){
        Producto producto = productoService.asignarDescuento(idProducto, idDescuento);
        return ResponseEntity.ok(producto);
    }

    @PatchMapping("/{idProducto}/addDiscount/{idCategoria}")
    public ResponseEntity<Producto> agregarCategoria(@PathVariable Long idProducto, @PathVariable Long idCategoria){
        Producto producto = productoService.agregarCategoria(idProducto, idCategoria);
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

    @GetMapping("/filtrarPorCategoria/{nombreCategoria}")
    public ResponseEntity<List<Producto>> filtroTalle(@PathVariable String talle){
        List<Producto> productos = productoService.filtrarPorTalle(talle);
        return ResponseEntity.ok(productos);
    }
}
