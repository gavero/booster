package com.booster.cinemagic.modelos.entidad;


import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "El titulo no debe ser null")
    @NotEmpty(message = "El titulo no debe ser vacio")
    @Size(max = 250, message = "El titulo es muy extenso")
    private String titulo;

    @Min(value = 60, message = "La duracion debe ser mayor a 60 mins")
    @NotNull(message = "La duracion no debe ser null")
    private int duracion;
    @NotNull(message = "El genero no debe ser null")
    @NotEmpty(message = "El genero no debe ser vacio")
    private String genero;

    @NotNull(message = "La clasificacion no debe ser null")
    @NotEmpty(message = "La clasificacion no debe ser vacia")
    @Size(min = 1)
    @Pattern(regexp = "[ABCD]", message = "La clasificacion solo puede ser A,B,C,D")
    private String clasificacion;

    public Pelicula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
