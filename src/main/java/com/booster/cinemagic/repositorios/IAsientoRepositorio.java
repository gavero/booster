package com.booster.cinemagic.repositorios;

import com.booster.cinemagic.entidadades.AsientoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsientoRepositorio extends JpaRepository<AsientoEntidad, Integer> {
}
