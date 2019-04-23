/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.TipoArticulo;

/**
 *
 * @author arevalo
 */
public class TipoArticuloFacadeTest extends AbstractTest<TipoArticulo>{ 

      @Override
    protected AbstractFacade<TipoArticulo> getFacade() {
       return new TipoArticuloFacade();
    }

    @Override
    protected TipoArticulo getEntity() {
        return new TipoArticulo(1);
    }
    
}
