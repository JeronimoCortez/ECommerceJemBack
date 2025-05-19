package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Detalle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.repositories.DetalleRepository;
import com.example.EcommerceBackJem.services.BaseService;

@RestController
@RequestMapping("/detalle")
public class DetalleController extends BaseController<Detalle, Long>{
    public DetalleController(BaseService<Detalle, Long> service) {
        super(service);
    }

    private DetalleRepository detalleRepository;
}
