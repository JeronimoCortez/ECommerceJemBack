package com.example.EcommerceBackJem.entities;

import com.example.EcommerceBackJem.entities.enums.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_de_compra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenCompra extends Base{
    @ManyToOne()
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @JsonIgnoreProperties("ordenesCompra")
    private Usuario usuario;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("ordenCompra")
    private List<Detalle> detalles = new ArrayList<>();


    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "precio_total")
    private Double precioTotal;
    @Column(name = "estado")
    private Estado estado;
}
