/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
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

  
}
