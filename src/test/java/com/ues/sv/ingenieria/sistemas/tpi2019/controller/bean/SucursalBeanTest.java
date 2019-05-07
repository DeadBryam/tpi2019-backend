/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.SucursalBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;

/**
 *
 * @author arevalo
 */
public class SucursalBeanTest extends AbstractBeanTest<Sucursal>{

    @Override
    protected AbstractFacade<Sucursal> getFacade() {
        return new SucursalFacade();
    }

    @Override
    public Sucursal getEntity() {
        return new Sucursal();
    }

    @Override
    protected AbstractBean<Sucursal> getBean() {
        return new SucursalBean();
    }
    
}
