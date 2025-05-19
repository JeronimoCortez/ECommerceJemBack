package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.TalleProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.TalleProductoService;

@RestController
@RequestMapping("/talle-producto")
public class TalleProductoController extends BaseController<TalleProducto, Long>{
    public TalleProductoController(BaseService<TalleProducto, Long> service) {
        super(service);
    }
    @Autowired
    private TalleProductoService talleProductoService;
}
