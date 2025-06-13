package com.example.EcommerceBackJem.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private String nombre;
    private Double precio;
    private Long idCategoria;
    private String descripcion;
    private String color;
    private String marca;
    private String imagen;
    private String genero;
    private List<TalleDTO> talles;
}
