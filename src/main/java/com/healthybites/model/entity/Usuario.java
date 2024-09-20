package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Usuario {
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
}
