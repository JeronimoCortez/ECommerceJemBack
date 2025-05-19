package com.example.EcommerceBackJem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "talle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Talle extends Base{
    @Column(name = "tipo_talle")
    private String tipo_talle;
}
