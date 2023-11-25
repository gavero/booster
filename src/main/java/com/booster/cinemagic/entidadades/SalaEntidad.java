package com.booster.cinemagic.entidadades;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SALA")
public class SalaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALA", nullable = false)
    private Integer id;

    @NotNull(message = "La descripcion no debe ser null")
    @NotEmpty(message = "La descripcio no debe ser vacia")
    @Size(max = 250, message = "El descripcion debe ser menor a 250 caracteres")
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;


    @Min(value = 1, message = "La duracion debe ser mayor a 0")
    @NotNull(message = "El total de asientos no debe ser null")
    @Column(name = "TOTAL_ASIENTOS", nullable = false)
    private Integer totalAsientos;


    @Min(value = 1, message = "El Id de Estado debe ser mayor a 0")
    @NotNull(message = "El Id de Estado no debe ser null")
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
