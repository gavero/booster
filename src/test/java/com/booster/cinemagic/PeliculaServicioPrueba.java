package com.booster.cinemagic;

import com.booster.cinemagic.entidadades.PeliculaEntidad;
import com.booster.cinemagic.repositorios.IPeliculaRepositorio;
import com.booster.cinemagic.servicios.implementacion.PeliculaServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

   @DisplayName("Test para listar las peliculas")
    @Test
    public void testObtenerPeliculas(){
        List<PeliculaEntidad> listaPeliculas = new ArrayList<PeliculaEntidad>();
        listaPeliculas.add(peliculaPrueba);
        when(peliculaServicio.obtenerPeliculas()).thenReturn(listaPeliculas);

        assertNotNull(peliculaServicio.obtenerPeliculas());
        assertEquals(1,listaPeliculas.size());
    }

    @DisplayName("Test para regresar ninguna pelicula")
    @Test
    public void testListaPeliculasVacia(){
        when(peliculaServicio.obtenerPeliculas()).thenReturn(Collections.emptyList());
        List<PeliculaEntidad> listaPeliculas = peliculaServicio.obtenerPeliculas();
        assertEquals(0,listaPeliculas.size());
    }

    @DisplayName("Test para consultar una pelicula por ID")
    @Test
    public void testObtenerPeliculaPorId(){
        when(iPeliculaRepositorio.findById(1)).thenReturn(Optional.ofNullable(peliculaPrueba));
        PeliculaEntidad peliculaActual = peliculaServicio.obtenerPeliculaPorId(1);
        assertEquals(peliculaPrueba,peliculaActual);
    }
    @DisplayName("Test para agregar una pelicula")
    @Test
    public void testAgregarPelicula(){
        when(iPeliculaRepositorio.save(peliculaPrueba)).thenReturn(peliculaPrueba);
        PeliculaEntidad peliculaAgregar = peliculaServicio.agregarPelicula(peliculaPrueba);
        assertNotNull(peliculaAgregar);
    }

    @DisplayName("Test para modificar una pelicula que existe")
    @Test
    public void testModificarPeliculaExiste(){
        when(iPeliculaRepositorio.findById(1)).thenReturn(Optional.ofNullable(peliculaPrueba));
        when(iPeliculaRepositorio.save(peliculaPrueba)).thenReturn(peliculaPrueba);
        peliculaPrueba.setClasificacion("A");
        peliculaPrueba.setGenero("Terror");

        PeliculaEntidad peliculaModificada = peliculaServicio.modificarPelicula(1,peliculaPrueba);

        assertEquals("A",peliculaModificada.getClasificacion());
        assertEquals("Terror",peliculaModificada.getGenero());
    }

    @DisplayName("Test no existe la pelicula")
    @Test
    public void testModificarPeliculaNoExiste(){
        when(iPeliculaRepositorio.findById(1)).thenReturn(Optional.ofNullable(peliculaPrueba));
        when(iPeliculaRepositorio.save(peliculaPrueba)).thenReturn(peliculaPrueba);
        peliculaPrueba.setClasificacion("A");
        peliculaPrueba.setGenero("Terror");

        PeliculaEntidad peliculaModificada = peliculaServicio.modificarPelicula(2,peliculaPrueba);

        assertNull(peliculaModificada);

    }
}
