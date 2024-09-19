package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "habito")
public class Habito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hidratacion", nullable = false)
    private float Hidratacion;

    @Column(name = "alimentacion", nullable = false)
    private float Alimentacion;

    @Column(name = "ejercicio", nullable = false)
    private float Ejercicio;

    @Column(name = "calidad_sueno", nullable = false)
    private float calidadSueno;

}
