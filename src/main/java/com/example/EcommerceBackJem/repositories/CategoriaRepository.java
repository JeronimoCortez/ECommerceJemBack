package com.example.EcommerceBackJem.repositories;

import com.example.EcommerceBackJem.entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long>{

    Optional<Categoria> findByNombre(String nombre);
}
