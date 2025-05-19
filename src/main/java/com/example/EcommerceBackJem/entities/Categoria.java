package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria extends Base{
    @Column(name = "nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private Tipo tipo;

    @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos = new ArrayList<>();
}
