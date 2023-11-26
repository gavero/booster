package com.booster.cinemagic;

import com.booster.cinemagic.entidadades.CarteleraEntidad;
import com.booster.cinemagic.repositorios.ICarteleraRepositorio;
import com.booster.cinemagic.servicios.implementacion.CarteleraServicio;
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

public class CarteleraServicioPrueba {

    @Mock
    ICarteleraRepositorio iCarteleraRepositorio;

    @InjectMocks
    CarteleraServicio carteleraServicio;
    
    CarteleraEntidad carteleraPrueba;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        carteleraPrueba = new CarteleraEntidad();
        carteleraPrueba.setId(1);
        carteleraPrueba.setFecha("Domingo 26 de Noviembre");
        carteleraPrueba.setHoraInicio("12:00");
        carteleraPrueba.setHoraFin("14:30");
        carteleraPrueba.setIdEstado(1);
        carteleraPrueba.setIdSala(1);
        carteleraPrueba.setIdPelicula(1);
    }

    @DisplayName("Test para listar las carteleras")
    @Test
    public void testObtenerCarteleras(){
        List<CarteleraEntidad> listaCarteleras = new ArrayList<CarteleraEntidad>();
        listaCarteleras.add(carteleraPrueba);
        System.out.println(listaCarteleras.size());

        when(carteleraServicio.obtenerCarteleras()).thenReturn(listaCarteleras);

        assertNotNull(carteleraServicio.obtenerCarteleras());
        assertEquals(1,listaCarteleras.size());

    }

    @DisplayName("Test para regresar ninguna cartelera")
    @Test
    public void testListaCartelerasVacia(){
        when(carteleraServicio.obtenerCarteleras()).thenReturn(Collections.emptyList());
        List<CarteleraEntidad> listaCarteleras = carteleraServicio.obtenerCarteleras();
        assertEquals(0,listaCarteleras.size());
    }

    @DisplayName("Test para consultar una cartelera por ID")
    @Test
    public void testObtenerCarteleraPorId(){
        when(iCarteleraRepositorio.findById(1)).thenReturn(Optional.ofNullable(carteleraPrueba));
        CarteleraEntidad carteleraActual = carteleraServicio.obtenerCarteleraPorId(1);
        assertEquals(carteleraPrueba,carteleraActual);
    }
    @DisplayName("Test para agregar una cartelera")
    @Test
    public void testAgregarCartelera(){
        when(iCarteleraRepositorio.save(carteleraPrueba)).thenReturn(carteleraPrueba);
        CarteleraEntidad carteleraAgregar = carteleraServicio.agregarCartelera(carteleraPrueba);
        assertNotNull(carteleraAgregar);
    }

    @DisplayName("Test para modificar una cartelera que existe")
    @Test
    public void testModificarCarteleraExiste(){
        when(iCarteleraRepositorio.findById(1)).thenReturn(Optional.ofNullable(carteleraPrueba));
        when(iCarteleraRepositorio.save(carteleraPrueba)).thenReturn(carteleraPrueba);
        carteleraPrueba.setHoraInicio("00:00");
        carteleraPrueba.setHoraFin("00:00");

        CarteleraEntidad carteleraModificada = carteleraServicio.modificarCartelera(1,carteleraPrueba);

        assertEquals("00:00",carteleraModificada.getHoraInicio());
        assertEquals("00:00",carteleraModificada.getHoraFin());
    }

    @DisplayName("Test no existe la cartelera")
    @Test
    public void testModificarCarteleraNoExiste(){
        when(iCarteleraRepositorio.findById(1)).thenReturn(Optional.ofNullable(carteleraPrueba));
        when(iCarteleraRepositorio.save(carteleraPrueba)).thenReturn(carteleraPrueba);
        carteleraPrueba.setHoraInicio("00:00");
        carteleraPrueba.setHoraFin("00:00");

        CarteleraEntidad carteleraModificada = carteleraServicio.modificarCartelera(2,carteleraPrueba);

        assertNull(carteleraModificada);

    }
}
