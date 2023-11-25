package com.booster.cinemagic.servicios;

import com.booster.cinemagic.entidadades.AsientoEntidad;


import java.util.List;

public interface IAsientoServicio {

    List<AsientoEntidad> obtenerAsientos();

    AsientoEntidad obtenerAsientoPorId(Integer id);

    AsientoEntidad agregarAsiento(AsientoEntidad asiento);

    AsientoEntidad modificarAsiento(Integer id, AsientoEntidad asiento);

    boolean eliminarAsiento(Integer id);
}
