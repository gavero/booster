package com.booster.cinemagic.servicio;

import com.booster.cinemagic.modelos.entidad.PeliculaEntidad;

import java.util.List;

public interface IPeliculaServicio {

    List<PeliculaEntidad> obtenerPeliculas();

   //Pelicula obtenerPeliculaPorId(Integer id) throws NotFoundCustomException;
    PeliculaEntidad obtenerPeliculaPorId(Integer id);

    PeliculaEntidad agregarPelicula(PeliculaEntidad pelicula);

    PeliculaEntidad modificarPelicula(Integer id, PeliculaEntidad pelicula);

    boolean eliminarPelicula(Integer id);
}
