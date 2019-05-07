/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.TipoMedidaBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.TipoMedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoMedida;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class TipoMedidaBeanTest extends AbstractBeanTest<TipoMedida>{

    TipoMedidaBean bean = new TipoMedidaBean();
    
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
    
    @Test
    public void onSelectTest() {
        bean.onSelect(new TipoMedida(1));
        Assert.assertTrue(bean.getBotonEdit());
    }
}
