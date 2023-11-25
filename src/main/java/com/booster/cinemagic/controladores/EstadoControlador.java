package com.booster.cinemagic.controladores;

import com.booster.cinemagic.excepciones.DatosInvalidosExcepcion;
import com.booster.cinemagic.excepciones.ElementoNoEncontradoExcepcion;
import com.booster.cinemagic.excepciones.IdNoValidoExcepcion;
import com.booster.cinemagic.entidadades.EstadoEntidad;
import com.booster.cinemagic.servicios.IEstadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cinemagic/v0/estado")
public class EstadoControlador {

    @Autowired
    IEstadoServicio estadoServicio;

    @GetMapping()
    public List<EstadoEntidad> consultarEstados() {
        return estadoServicio.obtenerEstados();
    }

    @GetMapping("/{id}")
    public EstadoEntidad consultarEstadoPorId(@PathVariable Integer id) {
        EstadoEntidad estado;
        if (id < 1) {
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410", HttpStatus.BAD_REQUEST);
        }

        estado = estadoServicio.obtenerEstadoPorId(id);
        if (estado == null) {
            throw new ElementoNoEncontradoExcepcion("No se encontro ningun estado con ese id:" + id, "Error 409", HttpStatus.NOT_FOUND);
        }
        return estado;
    }

    @PostMapping()
    public EstadoEntidad agregarEstado(@Valid @RequestBody EstadoEntidad estado, BindingResult resultado) {
        if (resultado.hasErrors()) {
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408", HttpStatus.BAD_REQUEST, resultado);
        }
        return estadoServicio.agregarEstado(estado);
    }

    @PutMapping("/{id}")
    public EstadoEntidad modificarEstado(@PathVariable Integer id, @Valid @RequestBody EstadoEntidad estadoModificado, BindingResult resultado) {
        EstadoEntidad estado;
        if (id < 1) {
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410", HttpStatus.BAD_REQUEST);
        }
        if (resultado.hasErrors()) {
            throw new DatosInvalidosExcepcion("Error de validacion - Favor de revisar los datos introducidos", "Error 408", HttpStatus.BAD_REQUEST, resultado);
        }
        estado = estadoServicio.modificarEstado(id, estadoModificado);
        if (estado == null) {
            throw new ElementoNoEncontradoExcepcion("No se encontro ningun estado con ese id:" + id, "Error 409", HttpStatus.NOT_FOUND);
        }

        return estado;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstado(@PathVariable Integer id) {
        boolean respuesta;
        if (id < 1) {
            throw new IdNoValidoExcepcion("El id debe ser numerico y mayor 0", "Error 410", HttpStatus.BAD_REQUEST);
        }
        respuesta = estadoServicio.eliminarEstado(id);
        if (!respuesta) {
            throw new ElementoNoEncontradoExcepcion("No se encontro ningun estado con ese id:" + id, "Error 409", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Se eliminó la estado con id: " + id);
    }


}
