package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

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
    private List<Talle> talles = new ArrayList<>();

    @Column(name = "color")
    private String color;

    @Column(name = "marca")
    private String marca;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "descuento_producto",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "descuento_id")
    )
    private List<Descuento> descuentos = new ArrayList<>();

    private String imagen;

}
