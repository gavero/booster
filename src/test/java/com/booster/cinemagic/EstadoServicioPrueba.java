package com.booster.cinemagic;

import com.booster.cinemagic.entidadades.EstadoEntidad;
import com.booster.cinemagic.repositorios.IEstadoRepositorio;
import com.booster.cinemagic.servicios.implementacion.EstadoServicio;
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
import static org.mockito.Mockito.when;

public class EstadoServicioPrueba {

    @Mock
    IEstadoRepositorio iEstadoRepositorio;

    @InjectMocks
    EstadoServicio estadoServicio;
    
    EstadoEntidad estadoPrueba;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        estadoPrueba = new EstadoEntidad();
        estadoPrueba.setId(1);
        estadoPrueba.setDescripcion("Test");
    }

    @DisplayName("Test para listar las estados")
    @Test
    public void testObtenerEstados(){
        List<EstadoEntidad> listaEstados = new ArrayList<EstadoEntidad>();
        listaEstados.add(estadoPrueba);
        when(estadoServicio.obtenerEstados()).thenReturn(listaEstados);

        assertNotNull(estadoServicio.obtenerEstados());
        assertEquals(1,listaEstados.size());
    }

    @DisplayName("Test para regresar ninguna estado")
    @Test
    public void testListaEstadosVacia(){
        when(estadoServicio.obtenerEstados()).thenReturn(Collections.emptyList());
        List<EstadoEntidad> listaEstados = estadoServicio.obtenerEstados();
        assertEquals(0,listaEstados.size());
    }

    @DisplayName("Test para consultar una estado por ID")
    @Test
    public void testObtenerPeliculaPorId(){
        when(iEstadoRepositorio.findById(1)).thenReturn(Optional.ofNullable(estadoPrueba));
        EstadoEntidad estadoActual = estadoServicio.obtenerEstadoPorId(1);
        assertEquals(estadoPrueba,estadoActual);
    }
    @DisplayName("Test para agregar una estado")
    @Test
    public void testAgregarPelicula(){
        when(iEstadoRepositorio.save(estadoPrueba)).thenReturn(estadoPrueba);
        EstadoEntidad estadoAgregar = estadoServicio.agregarEstado(estadoPrueba);
        assertNotNull(estadoAgregar);
    }

    @DisplayName("Test para modificar una estado que existe")
    @Test
    public void testModificarPeliculaExiste(){
        when(iEstadoRepositorio.findById(1)).thenReturn(Optional.ofNullable(estadoPrueba));
        when(iEstadoRepositorio.save(estadoPrueba)).thenReturn(estadoPrueba);
        estadoPrueba.setDescripcion("Completa");


        EstadoEntidad estadoModificado = estadoServicio.modificarEstado(1,estadoPrueba);

        assertEquals("Completa",estadoModificado.getDescripcion());
    }

    @DisplayName("Test no existe la estado")
    @Test
    public void testModificarPeliculaNoExiste(){
        when(iEstadoRepositorio.findById(1)).thenReturn(Optional.ofNullable(estadoPrueba));
        when(iEstadoRepositorio.save(estadoPrueba)).thenReturn(estadoPrueba);
        estadoPrueba.setDescripcion("Completa");

        EstadoEntidad estadoModificado = estadoServicio.modificarEstado(2,estadoPrueba);

        assertNull(estadoModificado);

    }
}
