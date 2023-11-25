package com.booster.cinemagic.repositorios;

import com.booster.cinemagic.entidadades.SalaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaRepositorio extends JpaRepository<SalaEntidad, Integer> {
}
