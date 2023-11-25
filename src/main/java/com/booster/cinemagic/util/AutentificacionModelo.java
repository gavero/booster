package com.booster.cinemagic.util;

public class AutentificacionModelo {

    private static final long serialVersionUID = 1L;

    private String usuario;

    private String clave;

    public AutentificacionModelo(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String username) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
