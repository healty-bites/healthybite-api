package com.healthybites.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "grupo_interes")
public class GrupoInteres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "es_privado", nullable = false)
    private boolean esPrivado;

    @JsonIgnore
    @OneToMany(mappedBy = "grupoInteres", cascade = CascadeType.ALL)
    private List<Cliente> miembro;

    @JsonIgnore
    @OneToMany(mappedBy = "grupoInteres", cascade = CascadeType.ALL)
    private List<Publicacion> publicacion;
}
