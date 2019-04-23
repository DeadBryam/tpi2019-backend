/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Bodega;

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
    
}
