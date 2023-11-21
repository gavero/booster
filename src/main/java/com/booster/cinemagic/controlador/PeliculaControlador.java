package com.booster.cinemagic.controlador;

import com.booster.cinemagic.modelos.entidad.Pelicula;
import com.booster.cinemagic.servicio.IPeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic/v0/pelicula")
public class PeliculaControlador {

    @Autowired
    IPeliculaServicio peliculaServicio;

    @GetMapping()
    public List<Pelicula> consultarPeliculas() {
        return peliculaServicio.obtenerPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula consultarPeliculaPorId(@PathVariable Integer id) {
        return peliculaServicio.obtenerPeliculaPorId(id);
    }

    @PostMapping()
    public Pelicula agregarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaServicio.agregarPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula modificarPelicula(@PathVariable Integer id, @RequestBody Pelicula peliculaModificada) {
        return peliculaServicio.modificarPelicula(id,peliculaModificada);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Integer id){
        peliculaServicio.eliminarPelicula(id);
    }

}
