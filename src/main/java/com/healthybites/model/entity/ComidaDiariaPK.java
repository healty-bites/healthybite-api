package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ComidaDiariaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "administrador_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_COMIDADIARIA_ADMINISTRADOR"))
    private Administrador administradorID;

    @ManyToOne
    @JoinColumn(name = "plan_alimentacion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_COMIDADIARIA_PLANALIMENTACION"))
    private PlanAlimentacion planAlimentacionID;
}
