package com.example.EcommerceBackJem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Direccion extends Base{
    @Column(name = "calle")
    private String calle;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "cp")
    private String cp;
}
