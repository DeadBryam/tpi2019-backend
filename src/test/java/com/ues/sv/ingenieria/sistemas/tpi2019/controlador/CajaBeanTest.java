/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Caja;

/**
 *
 * @author arevalo
 */
public class CajaBeanTest extends AbstractBeanTest<Caja>{

    @Override
    protected AbstractFacade<Caja> getFacade() {
        return new CajaFacade();
    }

    @Override
    public Caja getEntity() {
        return new Caja();
    }

    @Override
    protected AbstractBean<Caja> getBean() {
        return new CajaBean();
    }
    
}
