package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Detalle;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.DetalleRepository;

@Service
public class DetalleService extends BaseService<Detalle, Long>{
    public DetalleService(BaseRepository<Detalle, Long> baseRepository) {
        super(baseRepository);
    }

    private DetalleRepository detalleRepository;
}
