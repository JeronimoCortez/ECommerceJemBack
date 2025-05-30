package com.example.EcommerceBackJem.entities;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_ordenCompra")
    private OrdenCompra ordenCompra;
}
