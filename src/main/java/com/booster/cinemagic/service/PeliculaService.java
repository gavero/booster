package com.booster.cinemagic.service;

import com.booster.cinemagic.models.entities.Pelicula;
import com.booster.cinemagic.repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {

    @Autowired
    IPeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getPeliculas() {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas = peliculaRepository.findAll();
        return listaPeliculas;
    }

    @Override
    public Pelicula getPeliculaById(Integer id) {
        Pelicula pelicula = new Pelicula();
        pelicula = peliculaRepository.findById(id).orElse(null);
        return pelicula;
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(Integer id, Pelicula pelicula) {
        Pelicula existePelicula = getPeliculaById(id);

        if (existePelicula != null) {
            existePelicula.setTitulo(pelicula.getTitulo());
            existePelicula.setDuracion(pelicula.getDuracion());
            existePelicula.setGenero(pelicula.getGenero());
            existePelicula.setGenero(pelicula.getGenero());
            return peliculaRepository.save(existePelicula);
        } else {
            return null;
        }
    }

    @Override
    public void deletePelicula(Integer id) {
        peliculaRepository.deleteById(id);
    }


}
