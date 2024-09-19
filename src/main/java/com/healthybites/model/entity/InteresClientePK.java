package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class InteresClientePK {
    @ManyToOne
    @JoinColumn(name = "grupo_interes_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_INTERESCLIENTE_GRUPOINTERES"))
    private GrupoInteres grupoInteres;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_INTERESCLIENTE_CLIENTE"))
    private Cliente cliente;
}
