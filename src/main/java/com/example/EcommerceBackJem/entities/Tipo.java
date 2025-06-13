package com.example.EcommerceBackJem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tipo extends Base{
    @Column(name = "nombre")
    private String nombre;


}
