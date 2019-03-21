/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;

/**
 *
 * @author arevalo
 */
public class ArticuloFacadeTest extends AbstractTest<Articulo>{ 

      @Override
    protected AbstractFacade<Articulo> getFacade() {
       return new ArticuloFacade();
    }

    @Override
    protected Articulo getEntity() {
        return new Articulo("1");
    }
    
}
