package com.healthybites.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthybites.model.enums.ObjetivoPlan;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "plan_alimentacion")
public class PlanAlimentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private ObjetivoPlan objetivo;

    @Column(name = "duracion_dias", nullable = false)
    private int duracionDias;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "administrador_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PLANADMINISTRADOR_ADMINISTRADOR"))
    private Administrador administrador;

    @JsonIgnore
    @OneToMany(mappedBy = "planAlimentacion", cascade = CascadeType.ALL)
    private List<ComidaDiaria> comidaDiaria;
}
