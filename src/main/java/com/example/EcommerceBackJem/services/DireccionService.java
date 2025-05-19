package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Direccion;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.DireccionRepository;

@Service
public class DireccionService extends BaseService<Direccion, Long>{
    public DireccionService(BaseRepository<Direccion, Long> baseRepository) {
        super(baseRepository);
    }

    private DireccionRepository direccionRepository;
}
