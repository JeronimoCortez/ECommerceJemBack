package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Talle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.TalleRepository;

@Service
public class TalleService extends BaseService<Talle,Long>{
    public TalleService(BaseRepository<Talle, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private TalleRepository talleRepository;
}
