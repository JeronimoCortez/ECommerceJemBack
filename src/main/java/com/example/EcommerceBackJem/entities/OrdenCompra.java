package com.example.EcommerceBackJem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_de_compra")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenCompra extends Base{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dir_user", referencedColumnName = "id")
    private Direccion direccionUsuario;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detalle> detalles = new ArrayList<>();

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "precio_total")
    private Float precio_total;
    @Column(name = "metodo_de_pago")
    private String metodo_de_pago;
    @Column(name = "estado")
    private String estado;
}
