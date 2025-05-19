package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.DescuentoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.DescuentoRepository;

@Service
public class DecuentoProductoService extends BaseService<DescuentoProducto, Long>{
    public DecuentoProductoService(BaseRepository<DescuentoProducto, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private DescuentoRepository descuentoRepository;
}
