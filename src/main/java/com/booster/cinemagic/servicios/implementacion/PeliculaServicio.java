package com.booster.cinemagic.servicios.implementacion;

import com.booster.cinemagic.entidadades.PeliculaEntidad;
import com.booster.cinemagic.repositorios.IPeliculaRepositorio;
import com.booster.cinemagic.servicios.IPeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaServicio implements IPeliculaServicio {

    @Autowired
    IPeliculaRepositorio peliculaRepositorio;

    @Override
    public List<PeliculaEntidad> obtenerPeliculas() {
        List<PeliculaEntidad> listaPeliculas = new ArrayList<>();
        listaPeliculas = peliculaRepositorio.findAll();
        return listaPeliculas;
    }


    @Override
    public PeliculaEntidad obtenerPeliculaPorId(Integer id){
        PeliculaEntidad pelicula = new PeliculaEntidad();
        pelicula = peliculaRepositorio.findById(id).orElse(null);
        return pelicula;
    }

    @Override
    public PeliculaEntidad agregarPelicula(PeliculaEntidad pelicula) {
        return peliculaRepositorio.save(pelicula);
    }


    @Override
    public PeliculaEntidad modificarPelicula(Integer id, PeliculaEntidad pelicula) {
        PeliculaEntidad existePelicula = obtenerPeliculaPorId(id);

        if (existePelicula != null) {
            existePelicula.setTitulo(pelicula.getTitulo());
            existePelicula.setDuracion(pelicula.getDuracion());
            existePelicula.setGenero(pelicula.getGenero());
            existePelicula.setClasificacion(pelicula.getClasificacion());
            return peliculaRepositorio.save(existePelicula);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarPelicula(Integer id) {
        boolean esEliminado = true;
        try {
            peliculaRepositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            esEliminado = false;
        }

        return esEliminado;
    }


}
