/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class ArticuloRestTest {

    ArticuloFacade articuloFacade = mock(ArticuloFacade.class);
    ArticuloRest articuloRest = mock(ArticuloRest.class);
    List<Articulo> listaArticulo = new ArrayList<>();
    // Articulo articulo=mock(Articulo.class);

    @Before
    public void init() {
        Whitebox.setInternalState(articuloRest, "articuloFacade", articuloFacade);
        listaArticulo.add(new Articulo());
        listaArticulo.add(new Articulo());
        listaArticulo.add(new Articulo());
    }

    @Test
    public void findRangeTest() {
        doCallRealMethod().when(articuloRest).findRange(any(Integer.class), any(Integer.class));
        when(articuloFacade.findRange(any(Integer.class), any(Integer.class))).thenReturn(listaArticulo);
        when(articuloFacade.count()).thenReturn(listaArticulo.size());

        assertEquals(200, articuloRest.findRange(0, 2).getStatus());
    }

    @Test
    public void findArticuloLikeTest() {
        doCallRealMethod().when(articuloRest).findArticuloLike(any(String.class));
        when(articuloFacade.findLike(any(String.class))).thenReturn(listaArticulo);

        assertEquals(200, articuloRest.findArticuloLike("1").getStatus());
        assertEquals("Totalreg", articuloRest.findArticuloLike("").getHeaders()
                .keySet().toString().replaceAll("\\p{P}", ""));
    }
    
     @Test
    public void ArticuloLikeNameTest() {
        doCallRealMethod().when(articuloRest).findArticuloLikeName(any(String.class));
        when(articuloFacade.likeName(any(String.class))).thenReturn(listaArticulo);

        assertEquals(200, articuloRest.findArticuloLikeName("1").getStatus());
        assertEquals("Totalreg", articuloRest.findArticuloLikeName("").getHeaders()
                .keySet().toString().replaceAll("\\p{P}", ""));
    }
}
