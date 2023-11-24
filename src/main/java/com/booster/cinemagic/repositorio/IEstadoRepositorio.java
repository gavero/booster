package com.booster.cinemagic.repositorio;

import com.booster.cinemagic.modelos.entidad.EstadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepositorio extends JpaRepository<EstadoEntidad, Integer> {
}
