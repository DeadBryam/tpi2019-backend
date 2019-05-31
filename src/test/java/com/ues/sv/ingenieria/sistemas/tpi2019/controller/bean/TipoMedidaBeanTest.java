/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.TipoMedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoMedida;
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
public class TipoMedidaBeanTest extends AbstractBeanTest<TipoMedida>{

    @Override
    protected AbstractFacade<TipoMedida> getFacade() {
        return new TipoMedidaFacade();
    }

    @Override
    public TipoMedida getEntity() {
        return new TipoMedida();
    }

    @Override
    protected AbstractBean<TipoMedida> getBean() {
        return new TipoMedidaBean();
    }

    

    @Override
    protected String name() {
       return "tipoMedidaFacade";
    }
    
     TipoMedidaBean bean = mock(TipoMedidaBean.class);
    TipoMedidaFacade facade = mock(TipoMedidaFacade.class);
    TipoMedida tipoMedida = mock(TipoMedida.class);
    
      @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "tipoMedidaFacade", facade);
        doCallRealMethod().when(bean).onSelect(new TipoMedida(1));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
        doCallRealMethod().when(bean).cancelar();
        doCallRealMethod().when(bean).init();
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getTipoMedida();
        doCallRealMethod().when(bean).setTipoMedida(tipoMedida);
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new TipoMedida(1));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
    }
    
     @Test
    public void getandset(){
        when(bean.getEntity()).thenReturn(tipoMedida);
        when(bean.getTipoMedida()).thenReturn(tipoMedida);
        when(bean.getFacade()).thenReturn(facade);
        
        
        assertEquals(tipoMedida, bean.getEntity());
        
        assertEquals(tipoMedida, bean.getTipoMedida());
        assertEquals(facade, bean.getFacade());
        bean.setTipoMedida(tipoMedida);
        bean.cancelar();
        bean.init();
    }
}
