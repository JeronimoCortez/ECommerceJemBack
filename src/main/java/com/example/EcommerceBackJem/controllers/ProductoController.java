package com.example.EcommerceBackJem.controllers;


import com.example.EcommerceBackJem.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.repositories.ProductoRepository;
import com.example.EcommerceBackJem.services.BaseService;
@RestController
@RequestMapping("/producto")
public class ProductoController extends BaseController<Producto, Long> {
    public ProductoController(BaseService<Producto, Long> service) {
        super(service);
    }

    @Autowired
    private ProductoRepository productoRepository;
}
