package com.booster.cinemagic.servicio;

import com.booster.cinemagic.modelos.entidad.Pelicula;
import com.booster.cinemagic.repositorio.IPeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaServicio implements IPeliculaServicio {

    @Autowired
    IPeliculaRepositorio peliculaRepositorio;

    @Override
    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas = peliculaRepositorio.findAll();
        return listaPeliculas;
    }

    @Override
    public Pelicula obtenerPeliculaPorId(Integer id) {
        Pelicula pelicula = new Pelicula();
        pelicula = peliculaRepositorio.findById(id).orElse(null);
        return pelicula;
    }

    @Override
    public Pelicula agregarPelicula(Pelicula pelicula) {
        return peliculaRepositorio.save(pelicula);
    }

    @Override
    public Pelicula modificarPelicula(Integer id, Pelicula pelicula) {
        Pelicula existePelicula = obtenerPeliculaPorId(id);

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
    public void eliminarPelicula(Integer id) {
        peliculaRepositorio.deleteById(id);
    }


}
