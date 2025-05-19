package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.OrdenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.OrdenCompraRepository;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long>{
    public OrdenCompraService(BaseRepository<OrdenCompra, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
}
