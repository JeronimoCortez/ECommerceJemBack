package com.example.EcommerceBackJem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "descuento")
@Getter
@Setter
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

    @ManyToMany(mappedBy = "descuentos")
    private List<Producto> productos = new ArrayList<>();
}
