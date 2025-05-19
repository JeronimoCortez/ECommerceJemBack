package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario, Long>{
    public UsuarioService(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private UsuarioRepository usuarioRepository;
}
