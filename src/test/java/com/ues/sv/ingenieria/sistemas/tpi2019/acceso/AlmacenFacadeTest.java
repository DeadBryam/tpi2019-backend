/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Bodega;

/**
 *
 * @author arevalo
 */
public class AlmacenFacadeTest extends AbstractTest<Bodega>{ 

      @Override
    protected AbstractFacade<Bodega> getFacade() {
       return new BodegaFacade();
    }

    @Override
    protected Bodega getEntity() {
        return new Bodega("1");
    }
    
}
