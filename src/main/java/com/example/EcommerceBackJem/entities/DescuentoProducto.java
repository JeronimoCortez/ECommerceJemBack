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
public class DescuentoProducto extends Base{
    @OneToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_descuento", referencedColumnName = "id")
    private Descuento descuento;
}
