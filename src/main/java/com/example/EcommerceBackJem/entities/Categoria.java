package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
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
