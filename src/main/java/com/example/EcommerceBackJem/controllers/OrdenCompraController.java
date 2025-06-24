package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.OrdenCompra;
import com.example.EcommerceBackJem.entities.dto.EstadoDTO;
import com.example.EcommerceBackJem.entities.enums.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.OrdenCompraService;

import java.util.List;

@RestController
@RequestMapping("/orden-compra")
public class OrdenCompraController extends BaseController<OrdenCompra, Long> {
    public OrdenCompraController(BaseService<OrdenCompra, Long> service) {
        super(service);
    }

    @Autowired
    private OrdenCompraService ordenCompraService;

    @PatchMapping("/modificarEstado/{id}")
    public ResponseEntity<OrdenCompra> modificarEstado(@PathVariable Long id, @RequestBody EstadoDTO dto) {
        OrdenCompra ordenCompra = ordenCompraService.modificarEstado(id, dto.getEstado());
        return ResponseEntity.ok(ordenCompra);
    }

    @GetMapping("/ordersUser/{idUser}")
    public ResponseEntity<List<OrdenCompra>> ordenesPorUsuario(@PathVariable Long idUser) {
        List<OrdenCompra> ordenes = ordenCompraService.ordenesPorUsuario(idUser);
        return ResponseEntity.ok(ordenes);
    }

}