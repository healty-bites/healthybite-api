package com.healthybites.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cliente")
public class Cliente extends Usuario {

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "altura", nullable = false)
    private float altura;

    @Column(name = "peso", nullable = false)
    private float peso;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "plan_actual_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_PLAN"), nullable = false)
    private PlanAlimentacion planActualID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "suscripcion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_SUSCRIPCION"), nullable = false)
    private Suscripcion suscripcionID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "progreso_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_PROGRESO"), nullable = false)
    private Progreso progresoID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "grupo_interes_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTEGRUPO_INTERES"), nullable = false)
    private GrupoInteres grupoInteres;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "habitos_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CLIENTE_HABITOS"), nullable = false)
    private Habito habitos;

}
