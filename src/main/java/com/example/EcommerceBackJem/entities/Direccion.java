package com.example.EcommerceBackJem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "direccion")
@Getter
@Setter
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
