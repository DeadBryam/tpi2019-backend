/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.SucursalBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
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
public class SucursalBeanTest extends AbstractBeanTest<Sucursal>{

    @Override
    protected AbstractFacade<Sucursal> getFacade() {
        return new SucursalFacade();
    }

    @Override
    public Sucursal getEntity() {
        return new Sucursal();
    }

    @Override
    protected AbstractBean<Sucursal> getBean() {
        return new SucursalBean();
    }

    @Override
    protected String name() {
        return "sucursalFacade";
    }
    
     SucursalBean bean = mock(SucursalBean.class);
    SucursalFacade facade = mock(SucursalFacade.class);
    Sucursal sucursal =mock(Sucursal.class);
    
      @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "sucursalFacade", facade);
        doCallRealMethod().when(bean).onSelect(new Sucursal(id));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getSucursal();
        doCallRealMethod().when(bean).setSucursal(sucursal);
        doCallRealMethod().when(bean).cancelar();
        doCallRealMethod().when(bean).init();
        
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Sucursal(id));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
    }
    
    @Test
    public void getandset(){
        when(bean.getEntity()).thenReturn(sucursal);
        when(bean.getFacade()).thenReturn(facade);
        when(bean.getSucursal()).thenReturn(sucursal);
        
        assertEquals(sucursal, bean.getEntity());
        assertEquals(sucursal, bean.getSucursal());
        assertEquals(facade, bean.getFacade());
        bean.cancelar();
        bean.setSucursal(sucursal);
        bean.init();
        
    }
}
