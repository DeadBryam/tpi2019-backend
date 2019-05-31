/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
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
 * @param <T>
 */
public abstract class AbstractBeanTest<T> implements Serializable {

    List<T> Datos=new ArrayList<>();

    public abstract T getEntity();

    protected abstract AbstractFacade<T> getFacade();

    protected abstract AbstractBean<T> getBean();
    protected abstract  String name();
    public AbstractBean absbean =mock(getBean().getClass());
    public AbstractFacade absfacade=mock(getFacade().getClass());
    
    T entity = getEntity();
    String id = "200IQ";
    String absname;
    @Before
    public void init() {
        absname=name();
        Whitebox.setInternalState(absbean,absname, absfacade);
        when(absbean.getFacade()).thenReturn(absfacade);
        when(absbean.getEntity()).thenReturn(entity);
        doCallRealMethod().when(absbean).crear();
        doCallRealMethod().when(absbean).editar();
        doCallRealMethod().when(absbean).eliminar();
        doCallRealMethod().when(absbean).llenarLista();
        doCallRealMethod().when(absbean).getListaDatos();
        doCallRealMethod().when(absbean).setListaDatos(any(List.class));
        Datos.add(entity);
        Datos.add(entity);
        Datos.add(entity);
        
    }

    @Test
    public void crearTest() {
        System.out.println("crearTest");
        System.out.println("ver 0");
        absbean.crear();
        System.out.println("ver ");
        verify(absfacade).create(entity);
        System.out.println("ver 1");
        verify(absbean).llenarLista();
        System.out.println("ver 2");
    }

    @Test
    public void editarTest() {
        System.out.println("editarTest");

        absbean.editar();
        verify(absfacade).edit(entity);
        verify(absbean).llenarLista();
    }

    @Test
    public void eliminarTest() {
        System.out.println("eliminarTest");

        absbean.eliminar();
        verify(absfacade).remove(entity);
        verify(absbean).llenarLista();
    }

    @Test
    public void llenarListaTest() {
        System.out.println("llenarListaTest");

        assertEquals(null, absbean.getListaDatos());

        when(absfacade.findAll()).thenReturn(null);
        absbean.llenarLista();
        assertEquals(0, absbean.getListaDatos().size());

        when(absfacade.findAll()).thenReturn(Datos);
        absbean.llenarLista();
        assertEquals(3, absbean.getListaDatos().size());
        
        absbean.setListaDatos(Datos);
    }
}
