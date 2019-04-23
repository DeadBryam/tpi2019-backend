/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Sucursal;

/**
 *
 * @author arevalo
 */
public class SucursalFacadeTest extends AbstractTest<Sucursal>{

    @Override
    protected AbstractFacade<Sucursal> getFacade() {
        return new SucursalFacade();
    }

    @Override
    protected Sucursal getEntity() {
        return new Sucursal("1");
    }
    
    
}
