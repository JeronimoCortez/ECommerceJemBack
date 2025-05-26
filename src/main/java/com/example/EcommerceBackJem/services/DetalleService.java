package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Detalle;
import com.example.EcommerceBackJem.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.DetalleRepository;

@Service
public class DetalleService extends BaseService<Detalle, Long>{
    public DetalleService(BaseRepository<Detalle, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private ProductoRepository productoRepository;

}
