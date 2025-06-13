package com.example.EcommerceBackJem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "talle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Talle extends Base{
    @ManyToOne()
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @JsonBackReference
    private Producto producto;

    @Column(name = "talle")
    private String talle;

    @Column(name = "stock")
    private Integer stock;
}
