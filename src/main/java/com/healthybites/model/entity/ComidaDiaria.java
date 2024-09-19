package com.healthybites.model.entity;

import com.healthybites.model.enums.CategoriaComida;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comida_diaria")
@IdClass(ComidaDiariaPK.class)
public class ComidaDiaria {
    @Id
    private Integer administradorID;

    @Id
    private Integer planAlimentacionID;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "calorias", nullable = false)
    private float calorias;

    @Enumerated(EnumType.STRING)
    private CategoriaComida categoriaComida;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "plan_alimentacion_id", referencedColumnName = "id")
    private PlanAlimentacion planAlimentacion;
}
