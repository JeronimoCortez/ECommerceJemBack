package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Descuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;

@Service
public class DescuentoService extends BaseService<Descuento, Long>{

    public DescuentoService(BaseRepository<Descuento, Long> baseRepository) {
        super(baseRepository);
    }

    // Lo declaramos para metodos futuros
    @Autowired
    private DescuentoRepository decuentoRepository;
}
