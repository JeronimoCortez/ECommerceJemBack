package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Direccion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.DireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController extends BaseController<Direccion, Long>{
    public DireccionController(BaseService<Direccion, Long> service) {
        super(service);
    }

    private DireccionService direccionService;
}
