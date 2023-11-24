package com.booster.cinemagic.controlador;

import com.booster.cinemagic.excepciones.DatosInvalidosExcepcion;
import com.booster.cinemagic.excepciones.ElementoNoEncontradoExcepcion;
import com.booster.cinemagic.excepciones.IdNoValidoExcepcion;
import com.booster.cinemagic.util.ErrorModelo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    private static  final Logger LOG = LoggerFactory.getLogger(ControllerAdvice.class.getName());

     @ExceptionHandler(value = DatosInvalidosExcepcion.class)
    public ResponseEntity<ErrorModelo> excepcionSolicitud(DatosInvalidosExcepcion excepcion){
         List<String> errores = excepcion.getResultado().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
         LOG.debug(excepcion.getMessage(), excepcion);
        ErrorModelo errorModelo = new ErrorModelo(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),excepcion.getCodigo(), excepcion.getMessage(),errores);
        return new ResponseEntity<>(errorModelo, excepcion.getEstatus());
    }

    @ExceptionHandler(value = IdNoValidoExcepcion.class)
    public ResponseEntity<ErrorModelo> excepcionBusquedaPorId(IdNoValidoExcepcion excepcion){
        ErrorModelo errorModelo = new ErrorModelo(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),excepcion.getCodigo(), excepcion.getMessage());
        return new ResponseEntity<>(errorModelo, excepcion.getEstatus());
    }

    @ExceptionHandler(value = ElementoNoEncontradoExcepcion.class)
    public ResponseEntity<ErrorModelo> excepcionElementoNoEncontrado(ElementoNoEncontradoExcepcion excepcion){
        ErrorModelo errorModelo = new ErrorModelo(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),excepcion.getCodigo(), excepcion.getMessage());
        return new ResponseEntity<>(errorModelo, excepcion.getEstatus());
    }
}
