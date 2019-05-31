/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Medida;
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
public class MedidaBeanTest extends AbstractBeanTest<Medida>{

    @Override
    protected AbstractFacade<Medida> getFacade() {
        return new MedidaFacade();
    }

    @Override
    public Medida getEntity() {
        return new Medida();
    }

    @Override
    protected AbstractBean<Medida> getBean() {
        return new MedidaBean();
    }

    @Override
    protected String name() {
        return "medidaFacade";
    }
    
     MedidaBean bean = mock(MedidaBean.class);
    MedidaFacade facade = mock(MedidaFacade.class);
    Medida medida =mock(Medida.class);
    TipoMedida tipoMedida= mock(TipoMedida.class);
    
      @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "medidaFacade", facade);
        doCallRealMethod().when(bean).onSelect(new Medida(1));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
        doCallRealMethod().when(bean).cancelar();
        doCallRealMethod().when(bean).init();
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getMedida();
        doCallRealMethod().when(bean).getTipoMedida();
        doCallRealMethod().when(bean).setTipoMedida(tipoMedida);
        doCallRealMethod().when(bean).setMedida(medida);
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Medida(1));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
    }
    
     @Test
    public void getandset(){
        when(bean.getEntity()).thenReturn(medida);
        when(bean.getMedida()).thenReturn(medida);
        when(bean.getTipoMedida()).thenReturn(tipoMedida);
        when(bean.getFacade()).thenReturn(facade);
        
        assertEquals(medida, bean.getEntity());
        
        assertEquals(tipoMedida, bean.getTipoMedida());
        assertEquals(medida, bean.getMedida());
        assertEquals(facade, bean.getFacade());
        bean.setTipoMedida(tipoMedida);
        bean.setMedida(medida);
        bean.cancelar();
        bean.init();
    }
}
