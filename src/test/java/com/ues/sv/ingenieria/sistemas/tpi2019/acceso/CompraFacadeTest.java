/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Compra;

/**
 *
 * @author arevalo
 */
public class CompraFacadeTest extends AbstractTest<Compra>{ 

      @Override
    protected AbstractFacade<Compra> getFacade() {
       return new CompraFacade();
    }

    @Override
    protected Compra getEntity() {
        return new Compra(Short.parseShort("1"));
    }
    
}
