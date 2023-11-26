package com.booster.cinemagic.repositorios;

import com.booster.cinemagic.entidadades.CarteleraEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarteleraRepositorio extends JpaRepository<CarteleraEntidad, Integer> {
}
