package com.booster.cinemagic.entidadades;

import javax.persistence.*;

@Entity
@Table(name = "ASIENTO")
public class AsientoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASIENTO", nullable = false)
    private Integer id;

    @Column(name = "NUM_ASIENTO", nullable = false)
    private Integer numAsiento;

    @Column(name = "ID_ESTADO", nullable = false)
    private Integer idEstado;

    @OneToOne
    @JoinColumn(name = "ID_ESTADO", insertable = false, updatable = false)
    private EstadoEntidad estadoDesc;

    @Column(name = "ID_SALA", nullable = false)
    private Integer idSala;

    @OneToOne
    @JoinColumn(name = "ID_SALA", insertable = false, updatable = false)
    private SalaEntidad salaDesc;


    public AsientoEntidad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(Integer numAsiento) {
        this.numAsiento = numAsiento;
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

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public SalaEntidad getSalaDesc() {
        return salaDesc;
    }

    public void setSalaDesc(SalaEntidad salaDesc) {
        this.salaDesc = salaDesc;
    }
}
