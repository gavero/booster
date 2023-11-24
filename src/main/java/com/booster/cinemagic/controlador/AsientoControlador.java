package com.booster.cinemagic.controlador;

import com.booster.cinemagic.excepciones.DatosInvalidosExcepcion;
import com.booster.cinemagic.excepciones.ElementoNoEncontradoExcepcion;
import com.booster.cinemagic.excepciones.IdNoValidoExcepcion;
import com.booster.cinemagic.modelos.entidad.AsientoEntidad;
import com.booster.cinemagic.servicio.IAsientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cinemagic/v0/asiento")
public class AsientoControlador {

    @Autowired
    IAsientoServicio asientoServicio;

    @GetMapping()
    public List<AsientoEntidad> consultarAsientos() {
        return asientoServicio.obtenerAsientos();
    }

    @GetMapping("/{id}")
    public AsientoEntidad consultarAsientoPorId(@PathVariable Integer id) {
        AsientoEntidad asiento;
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410", HttpStatus.BAD_REQUEST);
        }

        asiento = asientoServicio.obtenerAsientoPorId(id);
        if(asiento == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ningun asiento con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }
        return asiento;
    }

    @PostMapping()
    public AsientoEntidad agregarAsiento(@Valid @RequestBody AsientoEntidad asiento, BindingResult resultado) {
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        return asientoServicio.agregarAsiento(asiento);
    }

    @PutMapping("/{id}")
    public AsientoEntidad modificarAsiento(@PathVariable Integer id, @Valid  @RequestBody AsientoEntidad asientoModificado, BindingResult resultado) {
        AsientoEntidad asiento;
        
        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        if(resultado.hasErrors()){
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408",HttpStatus.BAD_REQUEST, resultado);
        }
        asiento = asientoServicio.modificarAsiento(id,asientoModificado);
        if(asiento == null){
            throw new ElementoNoEncontradoExcepcion("No se encontro ningun asiento con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }

        return asiento;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAsiento(@PathVariable Integer id){
        boolean respuesta;

        if(id < 1){
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410",HttpStatus.BAD_REQUEST);
        }
        respuesta = asientoServicio.eliminarAsiento(id);
        if(!respuesta){
            throw new ElementoNoEncontradoExcepcion("No se encontro ningun asiento con ese id:" + id,"Error 409",HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Se eliminó el asiento con id: "+ id);
    }

}
