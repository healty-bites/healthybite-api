package com.healthybites.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "registro_progreso")
public class RegistroProgreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "peso_actual", nullable = false)
    private float pesoActual;

    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "progreso_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_REGISTROPROGRESO_PROGRESO"))
    private Progreso progreso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Progreso getProgreso() {
        return progreso;
    }

    public void setProgreso(Progreso progreso) {
        this.progreso = progreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(float pesoActual) {
        this.pesoActual = pesoActual;
    }
}
