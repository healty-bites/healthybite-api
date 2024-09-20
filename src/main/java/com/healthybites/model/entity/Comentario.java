package com.healthybites.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_COMENTARIO_CLIENTE"))
    private Cliente autorID;

    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "publicacion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_COMENTARIO_PUBLICACION"))
    private Publicacion publicacionID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "comentario_padre_id", referencedColumnName = "id")
    private Comentario comentarioPadre;

    @JsonIgnore
    @OneToMany(mappedBy = "comentarioPadre", cascade = CascadeType.ALL)
    private List<Comentario> comentariosHijos;
}
