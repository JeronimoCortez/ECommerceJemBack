package com.example.EcommerceBackJem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tipo extends Base{
    @Column(name = "nombre")
    private String nombre;
}
