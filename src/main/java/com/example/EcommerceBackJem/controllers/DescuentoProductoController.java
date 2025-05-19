package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.DescuentoProducto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.DecuentoProductoService;

@RestController
@RequestMapping("/descuento-producto")
public class DescuentoProductoController extends BaseController<DescuentoProducto, Long>{
    public DescuentoProductoController(BaseService<DescuentoProducto, Long> service) {
        super(service);
    }

    private DecuentoProductoService decuentoProductoService;
}
