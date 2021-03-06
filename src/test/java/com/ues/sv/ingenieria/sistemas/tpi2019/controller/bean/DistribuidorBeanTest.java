/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Distribuidor;
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
public class DistribuidorBeanTest extends AbstractBeanTest<Distribuidor>{

    @Override
    protected AbstractFacade<Distribuidor> getFacade() {
        return new DistribuidorFacade();
    }

    @Override
    public Distribuidor getEntity() {
        return new Distribuidor();
    }

    @Override
    protected AbstractBean<Distribuidor> getBean() {
        return new DistribuidorBean();
    }

    @Override
    protected String name() {
       return "facade";
    }
    DistribuidorBean bean = mock(DistribuidorBean.class);
    DistribuidorFacade facade = mock(DistribuidorFacade.class);
    
      @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "facade", facade);
        doCallRealMethod().when(bean).onSelect(new Distribuidor(id));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
            doCallRealMethod().when(bean).cancelar();
        doCallRealMethod().when(bean).init();
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getDistribuidor();
        doCallRealMethod().when(bean).setDistribuidor(distribuidor);
        doCallRealMethod().when(bean).setEntity(distribuidor);
        doCallRealMethod().when(bean).setFacade(facade);
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Distribuidor(id));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
    }
    
    Distribuidor distribuidor =mock(Distribuidor.class);
    @Test
    public void getandset(){
        when(bean.getEntity()).thenReturn(distribuidor);
        when(bean.getDistribuidor()).thenReturn(distribuidor);
        when(bean.getFacade()).thenReturn(facade);
        
        assertEquals(distribuidor, bean.getEntity());
        
        assertEquals(distribuidor, bean.getDistribuidor());
        assertEquals(facade, bean.getFacade());
        bean.setDistribuidor(distribuidor);
        bean.setEntity(distribuidor);
        bean.setFacade(facade);
        bean.cancelar();
        bean.init();
    }
    
    
}
