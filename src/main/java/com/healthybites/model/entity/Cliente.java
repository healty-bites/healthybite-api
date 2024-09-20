package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
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

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "altura", nullable = false)
    private float altura;

    @Column(name = "peso", nullable = false)
    private float peso;

    @ManyToOne
    @JoinColumn(name = "plan_actual_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_PLAN"), nullable = false)
    private PlanAlimentacion planActualID;

    @ManyToOne
    @JoinColumn(name = "suscripcion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_SUSCRIPCION"), nullable = false)
    private Suscripcion suscripcionID;

    @ManyToOne
    @JoinColumn(name = "progreso_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_PROGRESO"), nullable = false)
    private Progreso progresoID;

    @ManyToOne
    @JoinColumn(name = "grupo_interes_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTEGRUPO_INTERES"), nullable = false)
    private GrupoInteres grupoInteres;

    @OneToOne
    @JoinColumn(name = "habitos_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_HABITOS"), nullable = false)
    private Habito habitos;

}
