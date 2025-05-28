package com.example.EcommerceBackJem.controllers;


import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;
import com.example.EcommerceBackJem.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceBackJem.repositories.ProductoRepository;
import com.example.EcommerceBackJem.services.BaseService;
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

    @PatchMapping("/eliminarImagen/{id}")
    public ResponseEntity<Producto> eliminarImagen(@PathVariable Long id){
        Producto producto = productoService.eliminarImagen(id);
        return ResponseEntity.ok(producto);
    }
}
