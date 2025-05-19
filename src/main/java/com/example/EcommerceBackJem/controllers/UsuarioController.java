package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseController<Usuario, Long>{
    public UsuarioController(BaseService<Usuario, Long> service) {
        super(service);
    }
    @Autowired
    private UsuarioService usuarioService;
}
