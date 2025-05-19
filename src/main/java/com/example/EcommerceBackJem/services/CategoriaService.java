package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.CategoriaRepository;

@Service
public class CategoriaService extends BaseService<Categoria, Long>{
    public CategoriaService(BaseRepository<Categoria, Long> baseRepository) {
        super(baseRepository);
    }

    // Declaramos el repository para metodos futuros
    @Autowired
    private CategoriaRepository categoriaRepository;


}
