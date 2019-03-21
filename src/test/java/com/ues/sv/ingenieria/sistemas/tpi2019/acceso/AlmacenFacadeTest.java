/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AlmacenFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Almacen;

/**
 *
 * @author arevalo
 */
public class AlmacenFacadeTest extends AbstractTest<Almacen>{ 

      @Override
    protected AbstractFacade<Almacen> getFacade() {
       return new AlmacenFacade();
    }

    @Override
    protected Almacen getEntity() {
        return new Almacen("1");
    }
    
}
