package com.booster.cinemagic.servicios;

import com.booster.cinemagic.entidadades.SalaEntidad;

import java.util.List;

public interface ISalaServicio{

    List<SalaEntidad> obtenerSalas();

    SalaEntidad obtenerSalaPorId(Integer id);

    SalaEntidad agregarSala(SalaEntidad sala);

    SalaEntidad modificarSala(Integer id, SalaEntidad sala);

    boolean eliminarSala(Integer id);
}
