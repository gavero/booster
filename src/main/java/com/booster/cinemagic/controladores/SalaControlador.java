package com.booster.cinemagic.controladores;

import com.booster.cinemagic.excepciones.DatosInvalidosExcepcion;
import com.booster.cinemagic.excepciones.ElementoNoEncontradoExcepcion;
import com.booster.cinemagic.excepciones.IdNoValidoExcepcion;
import com.booster.cinemagic.entidadades.SalaEntidad;
import com.booster.cinemagic.servicios.ISalaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cinemagic/v0/sala")
public class SalaControlador {

    @Autowired
    ISalaServicio salaServicio;

    @GetMapping()
    public List<SalaEntidad> consultarSalas() {
        return salaServicio.obtenerSalas();
    }


    @GetMapping("/{id}")
    public SalaEntidad consultarSalaPorId(@PathVariable Integer id) {
        SalaEntidad sala;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410", HttpStatus.BAD_REQUEST);
        }

        sala = salaServicio.obtenerSalaPorId(id);
        if(sala == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna sala con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }
        return sala;
    }

    @PostMapping()
    public SalaEntidad agregarSala(@Valid @RequestBody SalaEntidad sala, BindingResult resultado) {
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        return salaServicio.agregarSala(sala);
    }


    @PutMapping("/{id}")
    public SalaEntidad modificarSala(@PathVariable Integer id, @Valid  @RequestBody SalaEntidad salaModificada, BindingResult resultado) {
        SalaEntidad sala;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        sala = salaServicio.modificarSala(id,salaModificada);
        if(sala == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna sala con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }

        return sala;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSala(@PathVariable Integer id){
        boolean respuesta;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        respuesta = salaServicio.eliminarSala(id);
        if(!respuesta){
            throw new ElementoNoEncontradoExcepcion("No se encontro ninguna sala con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Se eliminó la sala con id: "+ id);
    }


}
