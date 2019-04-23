/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.MedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Medida;

/**
 *
 * @author arevalo
 */
public class MedidaBeanTest extends AbstractBeanTest<Medida>{

    @Override
    protected AbstractFacade<Medida> getFacade() {
        return new MedidaFacade();
    }

    @Override
    public Medida getEntity() {
        return new Medida();
    }

    @Override
    protected AbstractBean<Medida> getBean() {
        return new MedidaBean();
    }
    
}
