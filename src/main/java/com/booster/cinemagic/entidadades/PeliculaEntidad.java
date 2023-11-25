package com.booster.cinemagic.entidadades;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "PELICULA")
public class PeliculaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PELICULA", nullable = false)
    private Integer id;

    @NotNull(message = "El titulo no debe ser null")
    @NotEmpty(message = "El titulo no debe ser vacio")
    @Size(max = 250, message = "El titulo es muy extenso")
    @Column(name = "TITULO", nullable = false, length = 250)
    private String titulo;

    @Min(value = 60, message = "La duracion debe ser mayor a 60 mins")
    @NotNull(message = "La duracion no debe ser null")
    @Column(name = "DURACION", nullable = false)
    private int duracion;

    @NotNull(message = "El genero no debe ser null")
    @NotEmpty(message = "El genero no debe ser vacio")
    @Column(name = "GENERO", nullable = false, length = 250)
    private String genero;

    @NotNull(message = "La clasificacion no debe ser null")
    @NotEmpty(message = "La clasificacion no debe ser vacia")
    @Size(min = 1)
    @Pattern(regexp = "[ABCD]", message = "La clasificacion solo puede ser A,B,C,D")
    @Column(name = "CLASIFICACION", nullable = false, length = 250)
    private String clasificacion;

    public PeliculaEntidad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
