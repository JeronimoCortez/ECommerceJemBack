package com.example.EcommerceBackJem.entities;

import com.example.EcommerceBackJem.entities.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario extends Base{
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "rol")
    private Role rol;
}
