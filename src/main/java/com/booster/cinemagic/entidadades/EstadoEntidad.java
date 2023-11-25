package com.booster.cinemagic.entidadades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ESTADO")
public class EstadoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO", nullable = false)
    private Integer id;

    @NotNull(message = "La descripcion no debe ser null")
    @NotEmpty(message = "La descripcion no debe ser vacia")
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;



    public EstadoEntidad() {
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

}
