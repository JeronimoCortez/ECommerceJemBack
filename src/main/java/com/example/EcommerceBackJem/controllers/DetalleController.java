package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.Detalle;
import com.example.EcommerceBackJem.entities.dto.DetalleDTO;
import com.example.EcommerceBackJem.services.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceBackJem.repositories.DetalleRepository;
import com.example.EcommerceBackJem.services.BaseService;

import java.util.List;

@RestController
@RequestMapping("/detalle")
public class DetalleController extends BaseController<Detalle, Long>{
    public DetalleController(BaseService<Detalle, Long> service) {
        super(service);
    }

    @Autowired
    private DetalleService detalleService;

    @PostMapping("/create")
    public ResponseEntity<Detalle> crearDetalle(@RequestBody DetalleDTO detalleDTO) {
        Detalle detalle = detalleService.crearDetalle(detalleDTO);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/byOrden/{idOrden}")
    public ResponseEntity<List<Detalle>> detallesPorOrden(@PathVariable Long idOrden) {
        List<Detalle> detalles = detalleService.detallePorOrdenId(idOrden);
        return ResponseEntity.ok(detalles);
    }
}
