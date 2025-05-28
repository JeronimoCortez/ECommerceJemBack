package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "talle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Talle extends Base{
    @ManyToOne()
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    @Column(name = "talle")
    private String talle;

    @Column(name = "stock")
    private Integer stock;
}
