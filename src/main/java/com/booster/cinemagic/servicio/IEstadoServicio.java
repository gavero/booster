package com.booster.cinemagic.servicio;

import com.booster.cinemagic.modelos.entidad.EstadoEntidad;

import java.util.List;


public interface IEstadoServicio {

    List<EstadoEntidad> obtenerEstados();

    EstadoEntidad obtenerEstadoPorId(Integer id);

    EstadoEntidad agregarEstado(EstadoEntidad estado);

    EstadoEntidad modificarEstado(Integer id, EstadoEntidad estado);

    boolean eliminarEstado(Integer id);
}
