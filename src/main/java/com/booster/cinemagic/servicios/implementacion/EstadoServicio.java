package com.booster.cinemagic.servicios.implementacion;

import com.booster.cinemagic.entidadades.EstadoEntidad;
import com.booster.cinemagic.repositorios.IEstadoRepositorio;
import com.booster.cinemagic.servicios.IEstadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoServicio implements IEstadoServicio {

    @Autowired
    IEstadoRepositorio estadoRepositorio;

    @Override
    public List<EstadoEntidad> obtenerEstados() {
        List<EstadoEntidad> listaEstados = new ArrayList<>();
        listaEstados = estadoRepositorio.findAll();
        return listaEstados;
    }

    @Override
    public EstadoEntidad obtenerEstadoPorId(Integer id) {
        EstadoEntidad estado = new EstadoEntidad();
        estado = estadoRepositorio.findById(id).orElse(null);
        return estado;
    }

    @Override
    public EstadoEntidad agregarEstado(EstadoEntidad estado) {
        return estadoRepositorio.save(estado);
    }

    @Override
    public EstadoEntidad modificarEstado(Integer id, EstadoEntidad estado) {
        EstadoEntidad existeEstado = obtenerEstadoPorId(id);

        if (existeEstado != null) {
            existeEstado.setDescripcion(estado.getDescripcion());
            return estadoRepositorio.save(existeEstado);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarEstado(Integer id) {
        boolean esEliminado = true;
        try {
            estadoRepositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            esEliminado = false;
        }
        return esEliminado;
    }
}
