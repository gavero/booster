package com.booster.cinemagic.service;

import com.booster.cinemagic.models.entities.Pelicula;

import java.util.List;

public interface IPeliculaService {

    List<Pelicula> getPeliculas();

    Pelicula getPeliculaById(Integer id);

    Pelicula createPelicula(Pelicula pelicula);

    Pelicula updatePelicula(Integer id, Pelicula pelicula);

    void deletePelicula(Integer id);
}
