package com.example.EcommerceBackJem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "descuento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Descuento extends Base{
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Column(name = "fechaLimite")
    private Date fechaLimite;
    @Column(name = "descuento")
    private Float descuento;

    @OneToOne(mappedBy = "descuento")
    @JsonIgnore
    private Producto producto;
}
