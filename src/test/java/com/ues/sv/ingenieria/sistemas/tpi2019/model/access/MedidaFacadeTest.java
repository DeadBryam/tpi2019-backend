/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Medida;

/**
 *
 * @author arevalo
 */
public class MedidaFacadeTest extends AbstractTest<Medida>{ 

      @Override
    protected AbstractFacade<Medida> getFacade() {
       return new MedidaFacade();
    }

    @Override
    protected Medida getEntity() {
        return new Medida(1);
    }
    
}
