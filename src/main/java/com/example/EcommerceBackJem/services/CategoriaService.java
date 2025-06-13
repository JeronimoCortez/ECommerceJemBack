package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Categoria;
import com.example.EcommerceBackJem.entities.Producto;
import com.example.EcommerceBackJem.entities.Tipo;
import com.example.EcommerceBackJem.entities.dto.CategoriaDTO;
import com.example.EcommerceBackJem.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService extends BaseService<Categoria, Long>{
    public CategoriaService(BaseRepository<Categoria, Long> baseRepository) {
        super(baseRepository);
    }

    // Declaramos el repository para metodos futuros
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TipoRepository tipoRepository;

    public Categoria saveFromDTO(CategoriaDTO categoriaDTO) {

        Tipo tipo = Tipo.builder().nombre(categoriaDTO.getNombreTipo()).build();

        tipoRepository.save(tipo);

        Categoria categoria = Categoria.builder().nombre(categoriaDTO.getNombre()).tipo(tipo).productos(new ArrayList<Producto>()).build();

        return categoriaRepository.save(categoria);
    }

}
