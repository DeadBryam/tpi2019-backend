/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.TipoMedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.TipoMedida;

/**
 *
 * @author arevalo
 */
public class TipoMedidaFacadeTest extends AbstractTest<TipoMedida>{ 

      @Override
    protected AbstractFacade<TipoMedida> getFacade() {
       return new TipoMedidaFacade();
    }

    @Override
    protected TipoMedida getEntity() {
        return new TipoMedida(1);
    }
    
}
