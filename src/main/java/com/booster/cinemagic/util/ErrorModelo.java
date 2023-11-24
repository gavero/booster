package com.booster.cinemagic.util;

import java.util.Date;
import java.util.List;

public class ErrorModelo {

    private String fecha;

    private String codigo;
    private String mensaje;

    private List<String> errores;


    public ErrorModelo(String fecha,String codigo, String mensaje, List<String> errores) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.errores = errores;
    }

    public ErrorModelo(String fecha, String codigo, String mensaje) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }
}
