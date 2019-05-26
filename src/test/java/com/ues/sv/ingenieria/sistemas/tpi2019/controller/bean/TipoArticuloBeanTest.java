/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.TipoArticuloBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.TipoArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.TipoArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoArticulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoArticulo;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class TipoArticuloBeanTest extends AbstractBeanTest<TipoArticulo> {

    
    @Override
    protected AbstractFacade<TipoArticulo> getFacade() {
        return new TipoArticuloFacade();
    }

    @Override
    public TipoArticulo getEntity() {
        return new TipoArticulo();
    }

    @Override
    protected AbstractBean<TipoArticulo> getBean() {
        return new TipoArticuloBean();
    }

    @Override
    protected String name() {
        return "tipoArticuloFacade";
    }
    
     TipoArticuloBean bean = mock(TipoArticuloBean.class);
    TipoArticuloFacade facade = mock(TipoArticuloFacade.class);
    
      @Before
    public void initAr() {
        Whitebox.setInternalState(bean, "tipoArticuloFacade", facade);
        doCallRealMethod().when(bean).onSelect(new TipoArticulo(1));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).getBotonEdit();
        doCallRealMethod().when(bean).setBotonEdit(any(boolean.class));
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new TipoArticulo(1));
        assertTrue(bean.getBotonEdit());

        bean.onDeselect();
        verify(bean).setBotonEdit(false);
    }

    
}
