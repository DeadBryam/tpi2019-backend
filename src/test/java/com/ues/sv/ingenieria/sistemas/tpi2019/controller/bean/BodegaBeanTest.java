/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
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
public class BodegaBeanTest extends AbstractBeanTest<Bodega> {

    @Override
    protected AbstractFacade<Bodega> getFacade() {
        return new BodegaFacade();
    }

    @Override
    public Bodega getEntity() {
        return new Bodega();
    }

    @Override
    protected AbstractBean<Bodega> getBean() {
        return new BodegaBean();
    }

    @Override
    protected String name() {
        return "bodegaFacade";
    }

    BodegaBean bean = mock(BodegaBean.class);
    BodegaFacade facade = mock(BodegaFacade.class);

    @Test
    public void onChange() {
        List<Bodega> lis= new ArrayList<>();
        Whitebox.setInternalState(bean, "bodegaFacade", facade);
        doCallRealMethod().when(bean).onChange();
        when(facade.bodegaPorSucursal(any(String.class))).thenReturn(lis);
        bean.onChange();
        
        doCallRealMethod().when(bean).setSucursal(sucursal);
        bean.setSucursal(sucursal);
        bean.onChange();
    }
    Bodega bodega = mock(Bodega.class);
    Sucursal sucursal = mock(Sucursal.class);

    @Test
    public void setTest() {
        doCallRealMethod().when(bean).setBodega(bodega);
        doCallRealMethod().when(bean).setSucursal(sucursal);
        doCallRealMethod().when(bean).init();
        bean.setBodega(bodega);
        bean.setSucursal(sucursal);
        bean.init();
    }

    @Test
    public void getTest() {
        doCallRealMethod().when(bean).getBodega();
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getSucursal();
        when(bean.getEntity()).thenReturn(bodega);
        when(bean.getBodega()).thenReturn(bodega);
        when(bean.getFacade()).thenReturn(facade);
        when(bean.getSucursal()).thenReturn(sucursal);

        assertEquals(bodega, bean.getEntity());

        assertEquals(bodega, bean.getBodega());
        assertEquals(facade, bean.getFacade());
        assertEquals(sucursal, bean.getSucursal());

    }
}
