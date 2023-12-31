package com.booster.cinemagic.repositorios;

import com.booster.cinemagic.entidadades.EstadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepositorio extends JpaRepository<EstadoEntidad, Integer> {
}
