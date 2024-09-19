package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "interes_cliente")
@IdClass(InteresClientePK.class)
public class InteresCliente {
    @Id
    private Integer cliente;

    @Id
    private Integer grupoInteres;
}
