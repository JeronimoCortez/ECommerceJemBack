package com.example.EcommerceBackJem.controllers;

import com.example.EcommerceBackJem.entities.OrdenCompra;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EcommerceBackJem.services.BaseService;
import com.example.EcommerceBackJem.services.OrdenCompraService;

@RestController
@RequestMapping("/orden-compra")
public class OrdenCompraController extends BaseController<OrdenCompra, Long>{
    public OrdenCompraController(BaseService<OrdenCompra, Long> service) {
        super(service);
    }
    private OrdenCompraService ordenCompraService;
}
