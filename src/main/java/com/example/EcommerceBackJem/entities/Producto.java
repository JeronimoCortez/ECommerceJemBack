package com.example.EcommerceBackJem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "producto")
    @JsonIgnoreProperties("producto")
    private List<Detalle> detalles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("productos")
    private Categoria categoria;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Talle> talles = new ArrayList<>();

    @Column(name = "color")
    private String color;

    @Column(name = "marca")
    private String marca;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "descuento_id", referencedColumnName = "id")
    private Descuento descuento;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "genero")
    private String genero;

}
