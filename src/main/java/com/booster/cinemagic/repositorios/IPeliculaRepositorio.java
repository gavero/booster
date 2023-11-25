package com.booster.cinemagic.repositorios;

import com.booster.cinemagic.entidadades.PeliculaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepositorio extends JpaRepository<PeliculaEntidad, Integer> {

}
