package com.healthybites.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "progreso")
public class Progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "peso_objetivo", nullable = false)
    private float pesoObjetivo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PROGRESO_CLIENTE"))
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "progreso", cascade = CascadeType.ALL)
    private List<RegistroProgreso> registro;
}
