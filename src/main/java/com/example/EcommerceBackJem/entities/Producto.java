package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Float precio;

    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<TalleProducto> talleProductos = new ArrayList<>();

    @Column(name = "color")
    private String color;

    @Column(name = "marca")
    private String marca;

}
