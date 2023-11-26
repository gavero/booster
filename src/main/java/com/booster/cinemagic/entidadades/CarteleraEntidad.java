package com.booster.cinemagic.entidadades;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "CARTELERA_PELICULA")
public class CarteleraEntidad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTELERA", nullable = false)
    private Integer id;

    @NotNull(message = "La fecha no debe ser null")
    @NotEmpty(message = "La fecha no debe ser vacia")
    @Column(name = "FECHA", nullable = false, length = 250)
    private String fecha;

    @NotNull(message = "La hora inicio no debe ser null")
    @NotEmpty(message = "La hora inicio no debe ser vacia")
    @Column(name = "HORA_INICIO", nullable = false, length = 250)
    private String horaInicio;

    @NotNull(message = "La hora inicio no debe ser null")
    @NotEmpty(message = "La hora inicio no debe ser vacia")
    @Column(name = "HORA_FIN", nullable = false, length = 250)
    private String horaFin;

    @Min(value = 1, message = "El Id de Estado debe ser mayor a 0")
    @NotNull(message = "El Id de Estado no debe ser null")
    @Column(name = "ID_ESTADO", nullable = false)
    private Integer idEstado;

    @OneToOne
    @JoinColumn(name = "ID_ESTADO", insertable = false, updatable = false)
    private EstadoEntidad estadoDesc;

    @Min(value = 1, message = "El Id de Sala debe ser mayor a 0")
    @NotNull(message = "El Id de Sala no debe ser null")
    @Column(name = "ID_SALA", nullable = false)
    private Integer idSala;

    @OneToOne
    @JoinColumn(name = "ID_SALA", insertable = false, updatable = false)
    private SalaEntidad salaDesc;

    @Min(value = 1, message = "El Id de Pelicula debe ser mayor a 0")
    @NotNull(message = "El Id de Pelicula no debe ser null")
    @Column(name = "ID_PELICULA", nullable = false)
    private Integer idPelicula;

    @OneToOne
    @JoinColumn(name = "ID_PELICULA", insertable = false, updatable = false)
    private PeliculaEntidad peliculaDesc;


    public CarteleraEntidad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
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

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public PeliculaEntidad getPeliculaDesc() {
        return peliculaDesc;
    }

    public void setPeliculaDesc(PeliculaEntidad peliculaDesc) {
        this.peliculaDesc = peliculaDesc;
    }
}
