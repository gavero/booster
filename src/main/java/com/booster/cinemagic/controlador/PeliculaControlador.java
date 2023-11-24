package com.booster.cinemagic.controlador;

import com.booster.cinemagic.excepciones.DatosInvalidosExcepcion;
import com.booster.cinemagic.excepciones.ElementoNoEncontradoExcepcion;
import com.booster.cinemagic.excepciones.IdNoValidoExcepcion;
import com.booster.cinemagic.modelos.entidad.Pelicula;
import com.booster.cinemagic.servicio.IPeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/cinemagic/v0/pelicula")
public class PeliculaControlador {

    @Autowired
    IPeliculaServicio peliculaServicio;

    /*
    @GetMapping()
    public ResponseEntity<List<Pelicula>> consultarPeliculas() {
        List<Pelicula> listaPeliculas;
        try{
            listaPeliculas = peliculaServicio.obtenerPeliculas();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(listaPeliculas);
    }
    */

    @GetMapping()
    public List<Pelicula> consultarPeliculas() {
            return peliculaServicio.obtenerPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula consultarPeliculaPorId(@PathVariable Integer id) {
        Pelicula pelicula;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }

        pelicula = peliculaServicio.obtenerPeliculaPorId(id);
        if(pelicula == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna pelicula con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }
        return peliculaServicio.obtenerPeliculaPorId(id);
    }

    @PostMapping()
    public Pelicula agregarPelicula(@Valid @RequestBody Pelicula pelicula, BindingResult resultado) {
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        return peliculaServicio.agregarPelicula(pelicula);
    }


    @PutMapping("/{id}")
    public Pelicula modificarPelicula(@PathVariable Integer id,@Valid  @RequestBody Pelicula peliculaModificada, BindingResult resultado) {
        Pelicula pelicula;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        pelicula = peliculaServicio.modificarPelicula(id,peliculaModificada);
        if(pelicula == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna pelicula con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }



        return pelicula;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPelicula(@PathVariable Integer id){
        boolean respuesta;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        respuesta = peliculaServicio.eliminarPelicula(id);
        if(!respuesta){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna pelicula con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Se eliminó la pelicula con id: "+ id);
    }

}
