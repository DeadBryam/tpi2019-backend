/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.MedidaBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Medida;

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

    @Override
    protected String name() {
        return "medidaFacade";
    }
    
}
