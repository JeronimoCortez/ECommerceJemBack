package com.example.EcommerceBackJem.services;

import com.example.EcommerceBackJem.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EcommerceBackJem.repositories.BaseRepository;
import com.example.EcommerceBackJem.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService extends BaseService<Producto, Long>{
    public ProductoService(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private ProductoRepository productoRepository;



}
