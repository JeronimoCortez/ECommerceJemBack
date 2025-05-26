package com.example.EcommerceBackJem.entities;

import com.example.EcommerceBackJem.entities.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario extends Base implements UserDetails {
    @Column(name = "userName")
    private String userName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "rol")
    private Role rol;
    @Column(name = "dni")
    private String dni;
    @Column(name = "phone")
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "usuario_dir",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "direccion_id")
    )
    private List<Direccion> direcciones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.getRol().name()));
    }

    @Override
    public String getPassword() {
        return this.contraseña;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
