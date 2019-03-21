/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Venta;

/**
 *
 * @author arevalo
 */
public class VentaFacadeTest extends AbstractTest<Venta>{


    @Override
    protected AbstractFacade<Venta> getFacade() {
       return new VentaFacade();
    }

    @Override
    protected Venta getEntity() {
        return new Venta(Short.parseShort("1"));
    }
    

}
