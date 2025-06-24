package com.example.EcommerceBackJem.entities.dto;

import com.example.EcommerceBackJem.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleDTO {
    String talle;
    Long idProducto;
    Double cantidad;
}
