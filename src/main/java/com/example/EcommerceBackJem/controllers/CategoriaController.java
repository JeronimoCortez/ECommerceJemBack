package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.CategoriaService;
@RestController
@RequestMapping("/categoria")
public class CategoriaController extends BaseController<Categoria, Long>{
    public CategoriaController(BaseService<Categoria, Long> service) {
        super(service);
    }
    // Declaramos para metodos futuros
    @Autowired
    private CategoriaService categoriaService;
}

