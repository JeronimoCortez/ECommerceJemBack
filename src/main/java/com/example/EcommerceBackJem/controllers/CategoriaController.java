package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Categoria;
import com.example.EcommerceBackJem.entities.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/create")
    public ResponseEntity<Categoria> createCategoria(@RequestBody CategoriaDTO categoriaDTO){
        Categoria categoriaCreada = categoriaService.saveFromDTO(categoriaDTO);
        return ResponseEntity.ok(categoriaCreada);
    }


}

