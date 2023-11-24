package com.booster.cinemagic.servicio;

import com.booster.cinemagic.modelos.entidad.AsientoEntidad;


import java.util.List;

public interface IAsientoServicio {

    List<AsientoEntidad> obtenerAsientos();

    AsientoEntidad obtenerAsientoPorId(Integer id);

    AsientoEntidad agregarAsiento(AsientoEntidad asiento);

    AsientoEntidad modificarAsiento(Integer id, AsientoEntidad asiento);

    boolean eliminarAsiento(Integer id);
}
