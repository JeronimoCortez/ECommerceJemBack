package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Talle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.repositories.TalleRepository;
import com.example.EcommerceBackJem.services.BaseService;

@RestController
@RequestMapping("/talle")
public class TalleController extends BaseController<Talle, Long>{
    public TalleController(BaseService<Talle, Long> service) {
        super(service);
    }
    @Autowired
    private TalleRepository talleRepository;
}
