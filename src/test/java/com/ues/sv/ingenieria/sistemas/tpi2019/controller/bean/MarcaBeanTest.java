/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MarcaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Marca;
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
public class MarcaBeanTest extends AbstractBeanTest<Marca>{
    
    @Override
    public Marca getEntity() {
        return new Marca();
    }

    @Override
    protected AbstractFacade<Marca> getFacade() {
        return new MarcaFacade();
    }

    @Override
    protected AbstractBean<Marca> getBean() {
        return new MarcaBean();
    }
    @Override
    protected String name() {
        return "marcaFacade";
    }
    
     MarcaBean bean = mock(MarcaBean.class);
    MarcaFacade facade = mock(MarcaFacade.class);
    Marca marca=mock(Marca.class);
    
      @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "marcaFacade", facade);
        doCallRealMethod().when(bean).onSelect(new Marca(1));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
        doCallRealMethod().when(bean).cancelar();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getMarca();
        doCallRealMethod().when(bean).init();
        doCallRealMethod().when(bean).setMarca(marca);
                
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Marca(1));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
    }
    
    @Test
    public void getandset(){
        when(bean.getEntity()).thenReturn(marca);
        when(bean.getMarca()).thenReturn(marca);
        when(bean.getFacade()).thenReturn(facade);
        
        
        assertEquals(marca, bean.getEntity());
        
        assertEquals(marca, bean.getMarca());
        assertEquals(facade, bean.getFacade());
        bean.setMarca(marca);
        bean.cancelar();
        bean.setMarca(marca);
        bean.init();
    }
}
