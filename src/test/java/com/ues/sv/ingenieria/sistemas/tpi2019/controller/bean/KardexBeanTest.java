/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
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
public class KardexBeanTest extends AbstractBeanTest<Kardex>{

    @Override
    protected AbstractFacade<Kardex> getFacade() {
        return new KardexFacade();
    }

    @Override
    public Kardex getEntity() {
        return new Kardex();
    }

    @Override
    protected AbstractBean<Kardex> getBean() {
        return new KardexBean();
    }

    @Override
    protected String name() {
        return "kardexFacade";
    }
    
    KardexBean bean = mock(KardexBean.class);
    Kardex k= mock(Kardex.class);
    KardexFacade facade = mock(KardexFacade.class);
    VentaFacade vfacade= mock(VentaFacade.class);
    CompraFacade cfacade= mock(CompraFacade.class);
    
    
      @Before
    public void initAr() {
        k= new Kardex();
        Whitebox.setInternalState(bean, "kardexFacade", facade);
        doCallRealMethod().when(bean).onSelect(new Kardex(1));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).setBtnPedido(any(boolean.class));
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Kardex(1));
        verify(bean).setBtnPedido(true);
        
        bean.onDeselect();
        verify(bean).setBtnPedido(false);
    }
}
