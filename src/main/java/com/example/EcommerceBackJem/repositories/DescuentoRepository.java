package com.example.EcommerceBackJem.repositories;

import com.example.EcommerceBackJem.entities.Descuento;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DescuentoRepository extends BaseRepository<Descuento, Long>{
    List<Descuento> findByFechaLimiteBeforeAndActivoTrue(LocalDateTime fecha);
}
