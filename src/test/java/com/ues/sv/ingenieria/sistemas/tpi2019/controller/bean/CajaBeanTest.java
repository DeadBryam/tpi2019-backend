/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
public class CajaBeanTest extends AbstractBeanTest<Caja> {

    @Override
    protected AbstractFacade<Caja> getFacade() {
        return new CajaFacade();
    }

    @Override
    public Caja getEntity() {
        return new Caja();
    }

    @Override
    protected AbstractBean<Caja> getBean() {
        return new CajaBean();
    }

    @Override
    protected String name() {
        return "cajaFacade";
    }

    CajaBean bean = mock(CajaBean.class);
    CajaFacade facade = mock(CajaFacade.class);
    Caja caja = mock(Caja.class);

    @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "cajaFacade", facade);
        doCallRealMethod().when(bean).onSelect(new Caja(1));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
        doCallRealMethod().when(bean).cancelar();
        doCallRealMethod().when(bean).init();
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getCaja();
        doCallRealMethod().when(bean).setCaja(caja);
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Caja(1));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
    }

    @Test
    public void getandset() {
        when(bean.getEntity()).thenReturn(caja);
        when(bean.getCaja()).thenReturn(caja);
        when(bean.getFacade()).thenReturn(facade);

        assertEquals(caja, bean.getEntity());

        assertEquals(caja, bean.getCaja());
        assertEquals(facade, bean.getFacade());
        bean.setCaja(caja);
        bean.cancelar();
        bean.init();
    }
}
