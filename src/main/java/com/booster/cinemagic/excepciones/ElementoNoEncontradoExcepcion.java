package com.booster.cinemagic.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ElementoNoEncontradoExcepcion extends RuntimeException{

    private String codigo;
    private HttpStatus estatus;

    public ElementoNoEncontradoExcepcion(String message, String codigo, HttpStatus estatus) {
        super(message);
        this.codigo = codigo;
        this.estatus = estatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HttpStatus getEstatus() {
        return estatus;
    }

    public void setEstatus(HttpStatus estatus) {
        this.estatus = estatus;
    }
}
