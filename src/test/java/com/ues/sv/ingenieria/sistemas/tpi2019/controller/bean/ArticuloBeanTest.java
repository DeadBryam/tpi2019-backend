/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class ArticuloBeanTest {
    ArticuloBean bean = mock(ArticuloBean.class);
    ArticuloFacade facade = mock(ArticuloFacade.class);
    Articulo entity = new Articulo();
    List<Articulo> list = new ArrayList<>();
    String id = "200IQ";

    @Before
    public void init() {
        Whitebox.setInternalState(bean, "articuloFacade", facade);
        when(bean.getFacade()).thenReturn(facade);
        when(bean.getEntity()).thenReturn(entity);
        doCallRealMethod().when(bean).crear();
        doCallRealMethod().when(bean).editar();
        doCallRealMethod().when(bean).eliminar();
        doCallRealMethod().when(bean).llenarLista();
        doCallRealMethod().when(bean).getListaDatos();
        doCallRealMethod().when(bean).onSelect(new Articulo(id));
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
        doCallRealMethod().when(bean).articuloCompleto(any(String.class));
        list.add(entity);
        list.add(entity);
        list.add(entity);
    }

    @Test
    public void crearTest() {
        System.out.println("crearTest");

        bean.crear();
        verify(facade).create(entity);
        verify(bean).llenarLista();
    }

    @Test
    public void editarTest() {
        System.out.println("editarTest");

        bean.editar();
        verify(facade).edit(entity);
        verify(bean).llenarLista();
    }

    @Test
    public void eliminarTest() {
        System.out.println("eliminarTest");

        bean.eliminar();
        verify(facade).remove(entity);
        verify(bean).llenarLista();
    }

    @Test
    public void llenarListaTest() {
        System.out.println("llenarListaTest");

        assertEquals(null, bean.getListaDatos());

        when(facade.findAll()).thenReturn(null);
        bean.llenarLista();
        assertEquals(0, bean.getListaDatos().size());

        when(facade.findAll()).thenReturn(list);
        bean.llenarLista();
        assertEquals(3, bean.getListaDatos().size());
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Articulo(id));
        assertTrue(bean.getBotonEdit());
    }

    @Test
    public void articuloCompletoTest() {
        System.out.println("articuloCompleto");
        String resultado;

        resultado = bean.articuloCompleto("");
        assertEquals("", resultado);

        when(facade.getArticuloCompleto(id)).thenReturn(id);
        resultado = bean.articuloCompleto(id);
        assertEquals(id, resultado);
    }
}