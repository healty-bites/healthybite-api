package com.healthybites.model.entity;

import com.healthybites.model.enums.CategoriaContenido;
import com.healthybites.model.enums.TipoContenido;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoContenido tipoContenido;

    @Enumerated(EnumType.STRING)
    private CategoriaContenido categoria;

    @ManyToOne
    @JoinColumn(name = "administrador_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CONTENIDO_ADMINISTRADOR"))
    private Administrador administrador;
}
