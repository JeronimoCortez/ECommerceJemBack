package com.example.EcommerceBackJem.controllers;


import com.example.EcommerceBackJem.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceBackJem.services.BaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseController <E extends Base, ID extends Serializable>{

    protected BaseService<E, ID> service;

    public BaseController(BaseService<E, ID> service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<E>> listar() throws Exception {
        List<E> entities = service.findAll();
        return ResponseEntity.ok(entities);
    }
    @GetMapping("/{id}")
    public Optional<E> buscarPorId(@PathVariable ID id) throws Exception {
        return service.findById(id);
    }
    @PostMapping()
    public ResponseEntity<E> crear(@RequestBody E entity) throws Exception {
        E entidadCreada = service.save(entity);
        return ResponseEntity.ok(entidadCreada);
    }
    @PutMapping()
    public ResponseEntity<E> actualizar(@RequestBody E entity) throws Exception {
        E entidadAct = service.update(entity);
        return ResponseEntity.ok(entidadAct);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable ID id) throws Exception {
        service.delete(id);
    }
}

