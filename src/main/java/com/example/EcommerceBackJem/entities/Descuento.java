package com.example.EcommerceBackJem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "descuento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Descuento extends Base{
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Column(name = "fechaLimite")
    private Date fechaLimite;
    @Column(name = "descuento")
    private Float descuento;
}
