package com.booster.cinemagic;

import com.booster.cinemagic.entidadades.SalaEntidad;
import com.booster.cinemagic.repositorios.ISalaRepositorio;
import com.booster.cinemagic.servicios.implementacion.SalaServicio;
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

public class SalaServicioPrueba {

    @Mock
    ISalaRepositorio iSalaRepositorio;

    @InjectMocks
    SalaServicio salaServicio;
    
    SalaEntidad salaPrueba;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        salaPrueba = new SalaEntidad();
        salaPrueba.setId(1);
        salaPrueba.setDescripcion("Sala VIP");
        salaPrueba.setTotalAsientos(80);
        salaPrueba.setIdEstado(1);
    }

    @DisplayName("Test para listar las salas")
    @Test
    public void testObtenerSalas(){
        List<SalaEntidad> listaSalas = new ArrayList<SalaEntidad>();
        listaSalas.add(salaPrueba);
        when(salaServicio.obtenerSalas()).thenReturn(listaSalas);

        assertNotNull(salaServicio.obtenerSalas());
        assertEquals(1,listaSalas.size());
    }

    @DisplayName("Test para regresar ninguna sala")
    @Test
    public void testListaSalasVacia(){
        when(salaServicio.obtenerSalas()).thenReturn(Collections.emptyList());
        List<SalaEntidad> listaSalas = salaServicio.obtenerSalas();
        assertEquals(0,listaSalas.size());
    }

    @DisplayName("Test para consultar una sala por ID")
    @Test
    public void testObtenerSalaPorId(){
        when(iSalaRepositorio.findById(1)).thenReturn(Optional.ofNullable(salaPrueba));
        SalaEntidad salaActual = salaServicio.obtenerSalaPorId(1);
        assertEquals(salaPrueba,salaActual);
    }
    @DisplayName("Test para agregar una sala")
    @Test
    public void testAgregarSala(){
        when(iSalaRepositorio.save(salaPrueba)).thenReturn(salaPrueba);
        SalaEntidad salaAgregar = salaServicio.agregarSala(salaPrueba);
        assertNotNull(salaAgregar);
    }

    @DisplayName("Test para modificar una sala que existe")
    @Test
    public void testModificarSalaExiste(){
        when(iSalaRepositorio.findById(1)).thenReturn(Optional.ofNullable(salaPrueba));
        when(iSalaRepositorio.save(salaPrueba)).thenReturn(salaPrueba);
        salaPrueba.setTotalAsientos(100);
        salaPrueba.setIdEstado(2);

        SalaEntidad salaModificada = salaServicio.modificarSala(1,salaPrueba);

        assertEquals(100,salaModificada.getTotalAsientos());
        assertEquals(2,salaModificada.getIdEstado());
    }

    @DisplayName("Test no existe la sala")
    @Test
    public void testModificarSalaNoExiste(){
        when(iSalaRepositorio.findById(1)).thenReturn(Optional.ofNullable(salaPrueba));
        when(iSalaRepositorio.save(salaPrueba)).thenReturn(salaPrueba);
        salaPrueba.setTotalAsientos(100);
        salaPrueba.setIdEstado(2);

        SalaEntidad salaModificada = salaServicio.modificarSala(2,salaPrueba);

        assertNull(salaModificada);

    }
}
