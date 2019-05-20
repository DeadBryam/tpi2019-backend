/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.MarcaBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MarcaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Marca;
import javax.validation.constraints.AssertTrue;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author arevalo
 */
public class MarcaBeanTest extends AbstractBeanTest<Marca>{
    
    MarcaBean beann = new MarcaBean();

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
    
    @Test
    public void onSelectTest(){
        beann.onSelect(new Marca(1));
        Assert.assertTrue(beann.getBotonEdit());
    }

    
    
}
