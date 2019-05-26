/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
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
public class ArticuloBeanTest extends AbstractBeanTest<Articulo>{
    
    @Override
    protected AbstractFacade<Articulo> getFacade() {
        return new ArticuloFacade();
    }

    @Override
    public Articulo getEntity() {
        return new Articulo();
    }
    
     @Override
    protected AbstractBean<Articulo> getBean() {
        return new ArticuloBean();
    }

    @Override
    protected String name() {
        return "articuloFacade";
    }
    
    
    ArticuloBean bean = mock(ArticuloBean.class);
    ArticuloFacade facade = mock(ArticuloFacade.class);
    String id = "200IQ";

    @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "articuloFacade", facade);
        doCallRealMethod().when(bean).onSelect(new Articulo(id));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
        doCallRealMethod().when(bean).articuloCompleto(any(String.class));
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Articulo(id));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
        
    }

    @Test
    public void articuloCompletoTest() {
        System.out.println("articuloCompleto  ");
        String resultado;

        resultado = bean.articuloCompleto("");
        assertEquals("", resultado);

        when(facade.getArticuloCompleto(id)).thenReturn(id);
        resultado = bean.articuloCompleto(id);
        assertEquals(id, resultado);
    }
}
