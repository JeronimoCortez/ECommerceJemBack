package com.example.EcommerceBackJem.repositories;

import com.example.EcommerceBackJem.entities.OrdenCompra;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompra, Long> {
    List<OrdenCompra> findAllByUsuarioId(Long idUser);
}
