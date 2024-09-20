package com.healthybites.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OrderColumn(name = "nombre", nullable = false)
    private String nombre;

    @OrderColumn(name = "email", nullable = false)
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @OrderColumn(name = "contrasena", nullable = false)
    private String contrasena;

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<PlanAlimentacion> planCreado;

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<Contenido> contenido;
}
