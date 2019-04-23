/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.TipoArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.TipoArticulo;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class TipoArticuloBeanTest extends AbstractBeanTest<TipoArticulo> {

    TipoArticuloBean bean = new TipoArticuloBean();
    
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

    @Test
    public void onSelectTest() {
        bean.onSelect(new TipoArticulo(1));
        Assert.assertTrue(bean.getBotonEdit());
    }
}
