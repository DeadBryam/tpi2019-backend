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
import org.junit.Test;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;
/**
 *
 * @author arevalo
 */
public class BodegaBeanTest extends AbstractBeanTest<Bodega>{

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
    
    BodegaBean bean =mock(BodegaBean.class);
    BodegaFacade facade = mock(BodegaFacade.class);

    @Test
    public void onChange(){
        Sucursal s= new Sucursal();
        Whitebox.setInternalState(bean, "bodegaFacade", facade);
        doCallRealMethod().when(facade).bodegaPorSucursal("APA1245");
        doCallRealMethod().when(bean).onChange();
//        doCallRealMethod().when(bean).getSucursal().setIdSucursal("APA1245");

        bean.onChange();
        
//        bean.getSucursal().setIdSucursal("APA1245");
        bean.onChange();
    }
}
