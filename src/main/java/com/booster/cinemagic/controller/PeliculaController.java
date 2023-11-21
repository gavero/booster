package com.booster.cinemagic.controller;

import com.booster.cinemagic.models.entities.Pelicula;
import com.booster.cinemagic.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic/v0/pelicula")
public class PeliculaController {

    @Autowired
    IPeliculaService peliculaService;

    @GetMapping()
    public List<Pelicula> getPeliculas() {
        return peliculaService.getPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable Integer id) {
        return peliculaService.getPeliculaById(id);
    }

    @PostMapping()
    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.createPelicula(pelicula);
    }


    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable Integer id, @RequestBody Pelicula updatedPelicula) {
        return peliculaService.updatePelicula(id,updatedPelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Integer id){
        peliculaService.deletePelicula(id);
    }

}
