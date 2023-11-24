package com.booster.cinemagic.modelos.entidad;

import javax.persistence.*;

@Entity
@Table(name = "SALA")
public class SalaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALA", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "TOTAL_ASIENTOS", nullable = false)
    private Integer totalAsientos;


    @Column(name = "ID_ESTADO", nullable = false)
    private Integer idEstado;

    @OneToOne
    @JoinColumn(name = "ID_ESTADO", insertable = false, updatable = false)
    private EstadoEntidad estadoDesc;


    public SalaEntidad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(Integer totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoEntidad getEstadoDesc() {
        return estadoDesc;
    }

    public void setEstadoDesc(EstadoEntidad estadoDesc) {
        this.estadoDesc = estadoDesc;
    }
}
