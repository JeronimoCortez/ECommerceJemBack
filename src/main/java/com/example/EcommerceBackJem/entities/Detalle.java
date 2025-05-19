package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Detalle extends Base{
    @Column(name = "cantidad")
    private Float cantidad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_ordenCompra")
    private OrdenCompra ordenCompra;
}
