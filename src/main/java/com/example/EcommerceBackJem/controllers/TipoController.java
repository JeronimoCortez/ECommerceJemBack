package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.repositories.TipoRepository;
import com.example.EcommerceBackJem.services.BaseService;

@RestController
@RequestMapping("/tipo")
public class TipoController extends BaseController<Tipo, Long>{
    public TipoController(BaseService<Tipo, Long> service) {
        super(service);
    }
    @Autowired
    private TipoRepository tipoRepository;
}
