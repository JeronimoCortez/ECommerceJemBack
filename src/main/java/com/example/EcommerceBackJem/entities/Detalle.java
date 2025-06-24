package com.example.EcommerceBackJem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "detalles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Detalle extends Base{
    @Column(name = "cantidad")
    private Double cantidad;

    @Column(name = "talle")
    private String talle;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @JsonIgnoreProperties("detalles")
    private Producto producto;


    @ManyToOne
    @JoinColumn(name = "id_ordenCompra", nullable = true)
    private OrdenCompra ordenCompra;
}
