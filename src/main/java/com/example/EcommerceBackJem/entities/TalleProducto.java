package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "talle_producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TalleProducto extends Base{
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "talle_id")
    private Talle talle;


    @Column(name = "stock")
    private Integer stock;
}
