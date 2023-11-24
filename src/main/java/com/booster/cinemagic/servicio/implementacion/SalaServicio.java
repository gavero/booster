package com.booster.cinemagic.servicio.implementacion;

import com.booster.cinemagic.modelos.entidad.SalaEntidad;
import com.booster.cinemagic.repositorio.ISalaRepositorio;
import com.booster.cinemagic.servicio.ISalaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaServicio implements ISalaServicio {

    @Autowired
    ISalaRepositorio salaRepositorio;

    @Override
    public List<SalaEntidad> obtenerSalas() {
        List<SalaEntidad> listaSalas = new ArrayList<>();
        listaSalas = salaRepositorio.findAll();
        return listaSalas;
    }

    @Override
    public SalaEntidad obtenerSalaPorId(Integer id) {
        SalaEntidad sala = new SalaEntidad();
        sala = salaRepositorio.findById(id).orElse(null);
        return sala;
    }

    @Override
    public SalaEntidad agregarSala(SalaEntidad sala) {
        return salaRepositorio.save(sala);
    }

    @Override
    public SalaEntidad modificarSala(Integer id, SalaEntidad sala) {
        SalaEntidad existeSala = obtenerSalaPorId(id);

        if (existeSala != null) {
            existeSala.setDescripcion(sala.getDescripcion());
            existeSala.setTotalAsientos(sala.getTotalAsientos());
            existeSala.setIdEstado(sala.getIdEstado());
            existeSala.setEstadoDesc(sala.getEstadoDesc());
            return salaRepositorio.save(existeSala);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarSala(Integer id) {
        boolean esEliminado = true;
        try {
            salaRepositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            esEliminado = false;
        }
        return esEliminado;
    }
}
