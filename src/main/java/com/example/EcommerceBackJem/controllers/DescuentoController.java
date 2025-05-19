package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Descuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.DescuentoService;

@RestController
@RequestMapping("/descuento")
public class DescuentoController extends BaseController<Descuento, Long>{
    public DescuentoController(BaseService<Descuento, Long> service) {
        super(service);
    }
    
    @Autowired
    private DescuentoService descuentoService;
}
