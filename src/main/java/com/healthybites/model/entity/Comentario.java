package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_COMENTARIO_CLIENTE"))
    private Cliente autorID;

    @ManyToOne
    @JoinColumn(name = "publicacion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_COMENTARIO_PUBLICACION"))
    private Publicacion publicacionID;

    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "comentario_padre_id", referencedColumnName = "id")
    private Comentario comentarioPadre;

    @OneToMany(mappedBy = "comentarioPadre", cascade = CascadeType.ALL)
    private List<Comentario> comentariosHijos;
}
