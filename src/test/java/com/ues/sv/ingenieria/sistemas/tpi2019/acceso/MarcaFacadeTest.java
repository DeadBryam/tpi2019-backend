/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.MarcaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Marca;

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
        return new Marca(Short.parseShort("1"));
    }
    
}
