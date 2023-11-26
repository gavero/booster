package com.booster.cinemagic;

import com.booster.cinemagic.entidadades.PeliculaEntidad;
import com.booster.cinemagic.repositorios.IPeliculaRepositorio;
import com.booster.cinemagic.servicios.implementacion.PeliculaServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class PeliculaServicioPrueba {

    @Mock
    IPeliculaRepositorio iPeliculaRepositorio;

    @InjectMocks
    PeliculaServicio peliculaServicio;

    PeliculaEntidad peliculaPrueba;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        peliculaPrueba = new PeliculaEntidad();
        peliculaPrueba.setId(1);
        peliculaPrueba.setTitulo("Batman");
        peliculaPrueba.setDuracion(120);
        peliculaPrueba.setGenero("Accion");
        peliculaPrueba.setClasificacion("B");
    }

    @Test
    public void testObtenerPeliculas(){
        List<PeliculaEntidad> listaPeliculas = new ArrayList<PeliculaEntidad>();
        listaPeliculas.add(peliculaPrueba);
        when(peliculaServicio.obtenerPeliculas()).thenReturn(listaPeliculas);

        assertNotNull(peliculaServicio.obtenerPeliculas());
    }

    @Test
    public void testObtenerPeliculaPorId(){
        when(iPeliculaRepositorio.findById(1)).thenReturn(Optional.ofNullable(peliculaPrueba));
        PeliculaEntidad peliculaActual = peliculaServicio.obtenerPeliculaPorId(1);
        assertEquals(peliculaPrueba,peliculaActual);
    }



}
