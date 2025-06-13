package com.example.EcommerceBackJem.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalleDTO {
    private String talle;
    private Integer stock;
}
