package com.booster.cinemagic.servicios.implementacion;

import com.booster.cinemagic.entidadades.AsientoEntidad;
import com.booster.cinemagic.repositorios.IAsientoRepositorio;
import com.booster.cinemagic.servicios.IAsientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsientoServicio implements IAsientoServicio {

    @Autowired
    IAsientoRepositorio asientoRepositorio;
    
    @Override
    public List<AsientoEntidad> obtenerAsientos() {
        List<AsientoEntidad> listaAsientos = new ArrayList<>();
        listaAsientos = asientoRepositorio.findAll();
        return listaAsientos;
    }

    @Override
    public AsientoEntidad obtenerAsientoPorId(Integer id) {
        AsientoEntidad asiento = new AsientoEntidad();
        asiento = asientoRepositorio.findById(id).orElse(null);
        return asiento;
    }

    @Override
    public AsientoEntidad agregarAsiento(AsientoEntidad asiento) {
        return asientoRepositorio.save(asiento);
    }

    @Override
    public AsientoEntidad modificarAsiento(Integer id, AsientoEntidad asiento) {
        AsientoEntidad existeAsiento = obtenerAsientoPorId(id);

        if (existeAsiento != null) {
            existeAsiento.setNumAsiento(asiento.getNumAsiento());
            existeAsiento.setIdEstado(asiento.getIdEstado());
            existeAsiento.setEstadoDesc(asiento.getEstadoDesc());
            existeAsiento.setIdSala(asiento.getIdSala());
            existeAsiento.setSalaDesc(asiento.getSalaDesc());
            return asientoRepositorio.save(existeAsiento);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarAsiento(Integer id) {
        boolean esEliminado = true;
        try {
            asientoRepositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            esEliminado = false;
        }
        return esEliminado;
    }
}
