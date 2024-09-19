package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "administrador")
public class Administrador extends Usuario {

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<PlanAlimentacion> planCreado;

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<Contenido> contenido;
}
