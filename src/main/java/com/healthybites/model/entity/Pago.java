package com.healthybites.model.entity;

import com.healthybites.model.enums.EstadoPago;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "suscripcion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PAGO_SUSCRIPCION"))
    private Suscripcion suscripcion;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;
}
