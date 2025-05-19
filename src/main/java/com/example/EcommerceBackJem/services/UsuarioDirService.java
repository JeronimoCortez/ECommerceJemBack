package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.UsuarioDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.UsuarioDirRepository;

@Service
public class UsuarioDirService extends BaseService<UsuarioDir, Long>{
    public UsuarioDirService(BaseRepository<UsuarioDir, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private UsuarioDirRepository usuarioDirRepository;
}
