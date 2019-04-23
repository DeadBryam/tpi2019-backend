/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Caja;

/**
 *
 * @author arevalo
 */
public class CajaFacadeTest extends AbstractTest<Caja>{
      
    @Override
    protected AbstractFacade<Caja> getFacade() {
       return new CajaFacade();
    }

    @Override
    protected Caja getEntity() {
        return new Caja(1);
    }
    
}
