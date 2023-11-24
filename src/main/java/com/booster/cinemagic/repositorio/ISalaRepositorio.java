package com.booster.cinemagic.repositorio;

import com.booster.cinemagic.modelos.entidad.SalaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaRepositorio extends JpaRepository<SalaEntidad, Integer> {
}
