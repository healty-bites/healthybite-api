package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "grupo_interes_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PUBLICACION_GRUPOINTERES"))
    private GrupoInteres grupoInteres;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PUBLICACION_AUTOR"))
    private Cliente autor;

    @OneToMany(mappedBy = "publicacionID", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;
}
