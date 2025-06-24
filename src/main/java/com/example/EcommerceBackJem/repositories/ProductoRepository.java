package com.example.EcommerceBackJem.repositories;

import com.example.EcommerceBackJem.entities.Producto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{
    List<Producto> findByActivoTrue(Pageable pageable);
    List<Producto> findByMarca(String marca);
}
