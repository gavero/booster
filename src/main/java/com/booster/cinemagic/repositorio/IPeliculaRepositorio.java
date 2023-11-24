package com.booster.cinemagic.repositorio;

import com.booster.cinemagic.modelos.entidad.PeliculaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepositorio extends JpaRepository<PeliculaEntidad, Integer> {

}
