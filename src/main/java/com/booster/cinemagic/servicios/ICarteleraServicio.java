package com.booster.cinemagic.servicios;

import com.booster.cinemagic.entidadades.CarteleraEntidad;

import java.util.List;

public interface ICarteleraServicio {

    List<CarteleraEntidad> obtenerCarteleras();

    CarteleraEntidad obtenerCarteleraPorId(Integer id);

    CarteleraEntidad agregarCartelera(CarteleraEntidad cartelera);

    CarteleraEntidad modificarCartelera(Integer id, CarteleraEntidad cartelera);

    boolean eliminarCartelera(Integer id);

}
