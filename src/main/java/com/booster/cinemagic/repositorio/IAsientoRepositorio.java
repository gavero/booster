package com.booster.cinemagic.repositorio;

import com.booster.cinemagic.modelos.entidad.AsientoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsientoRepositorio extends JpaRepository<AsientoEntidad, Integer> {
}
