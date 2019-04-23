/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Distribuidor;

/**
 *
 * @author arevalo
 */
public class DistribuidorBeanTest extends AbstractBeanTest<Distribuidor>{

    @Override
    protected AbstractFacade<Distribuidor> getFacade() {
        return new DistribuidorFacade();
    }

    @Override
    public Distribuidor getEntity() {
        return new Distribuidor();
    }

    @Override
    protected AbstractBean<Distribuidor> getBean() {
        return new DistribuidorBean();
    }
    
}
