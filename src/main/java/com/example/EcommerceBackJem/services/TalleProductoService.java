package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.TalleProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.TalleProductoRepository;

@Service
public class TalleProductoService extends BaseService<TalleProducto, Long>{
    public TalleProductoService(BaseRepository<TalleProducto, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private TalleProductoRepository talleProductoRepository;
}
