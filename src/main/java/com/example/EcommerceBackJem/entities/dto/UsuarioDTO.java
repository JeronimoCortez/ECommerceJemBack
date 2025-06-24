package com.example.EcommerceBackJem.entities.dto;

import com.example.EcommerceBackJem.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String nombreCompleto;
    private String email;
    private String contrasenia;
    private Role rol;
    private String dni;
    private String phone;
}
