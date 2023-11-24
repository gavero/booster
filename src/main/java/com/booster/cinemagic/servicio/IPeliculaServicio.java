package com.booster.cinemagic.servicio;

import com.booster.cinemagic.modelos.entidad.Pelicula;

import java.util.List;

public interface IPeliculaServicio {

    List<Pelicula> obtenerPeliculas();

   //Pelicula obtenerPeliculaPorId(Integer id) throws NotFoundCustomException;
    Pelicula obtenerPeliculaPorId(Integer id);

    Pelicula agregarPelicula(Pelicula pelicula);

    Pelicula modificarPelicula(Integer id, Pelicula pelicula);

    boolean eliminarPelicula(Integer id);
}
