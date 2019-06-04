/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Venta;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Venta;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class ventaIT extends AbstractIT<Venta>{

   @Override
    public AbstractFacade<Venta> getFacade() {
       return new VentaFacade();
    }

    @Override
    public Venta getEntity() {
        return new Venta(1);
    }

    @Override
    public String name() {
        return "Venta";
    }

    @Override
    public Object Id() {
        return 1;
    }
    
    @Test
    public void testEdit() {
        System.out.println("edit-IT");

        et.begin();
        cut.create(reg1);
        et.commit();
        em.detach(reg1);

        et.begin();
        cut.edit(reg2);
        et.commit();

       Venta resultado = (Venta) em.createNamedQuery("Venta.findByIdVenta").setParameter("idVenta", id).getSingleResult();
        assertEquals(reg2.getIdVenta(), resultado.getIdVenta());
        assertEquals(reg2.getEstadoVenta(), resultado.getEstadoVenta());
    }
}
