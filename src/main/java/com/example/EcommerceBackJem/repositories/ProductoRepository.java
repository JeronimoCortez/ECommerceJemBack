package com.example.EcommerceBackJem.repositories;

import com.example.EcommerceBackJem.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{


}
