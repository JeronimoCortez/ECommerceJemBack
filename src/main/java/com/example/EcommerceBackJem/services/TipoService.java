package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.TipoRepository;

@Service
public class TipoService extends BaseService<Tipo, Long>{
    public TipoService(BaseRepository<Tipo, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private TipoRepository tipoRepository;
}
