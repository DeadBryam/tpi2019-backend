/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MarcaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Marca;

/**
 *
 * @author arevalo
 */
public class MarcaFacadeTest extends AbstractTest<Marca>{ 

      @Override
    protected AbstractFacade<Marca> getFacade() {
       return new MarcaFacade();
    }

    @Override
    protected Marca getEntity() {
        return new Marca(1);
    }
    
}
