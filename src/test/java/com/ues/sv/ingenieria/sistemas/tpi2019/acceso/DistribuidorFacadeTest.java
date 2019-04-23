/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Distribuidor;

public  class DistribuidorFacadeTest extends AbstractTest<Distribuidor>{ 

      @Override
    protected AbstractFacade<Distribuidor> getFacade() {
       return new DistribuidorFacade();
    }

    @Override
    protected Distribuidor getEntity() {
        return new Distribuidor("asdas");
    }
}
