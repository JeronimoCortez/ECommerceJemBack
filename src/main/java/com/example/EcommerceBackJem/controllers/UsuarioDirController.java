package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.UsuarioDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.repositories.UsuarioDirRepository;
import com.example.EcommerceBackJem.services.BaseService;

@RestController
@RequestMapping("/usuario-dir")
public class UsuarioDirController extends BaseController<UsuarioDir, Long>{
    public UsuarioDirController(BaseService<UsuarioDir, Long> service) {
        super(service);
    }
    @Autowired
    private UsuarioDirRepository usuarioDirRepository;
}
