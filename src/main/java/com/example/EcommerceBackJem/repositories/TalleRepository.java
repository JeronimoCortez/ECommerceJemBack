package com.example.EcommerceBackJem.repositories;

import com.example.EcommerceBackJem.entities.Talle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalleRepository extends BaseRepository<Talle, Long>{
    List<Talle> findByTalle(String talle);
}
