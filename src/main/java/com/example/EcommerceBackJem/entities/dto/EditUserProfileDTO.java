package com.example.EcommerceBackJem.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditUserProfileDTO {
    private String nombre;
    private String dni;
    private String phone;
}
