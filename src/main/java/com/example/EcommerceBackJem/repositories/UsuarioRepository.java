package com.example.EcommerceBackJem.repositories;

import com.example.EcommerceBackJem.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{
    Optional<Usuario> findByUserName(String userName);
}
