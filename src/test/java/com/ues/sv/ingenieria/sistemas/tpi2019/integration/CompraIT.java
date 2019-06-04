/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Compra;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Compra;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class CompraIT extends AbstractIT<Compra>{

   @Override
    public AbstractFacade<Compra> getFacade() {
       return new CompraFacade();
    }

    @Override
    public Compra getEntity() {
        return new Compra(1);
    }

    @Override
    public String name() {
        return "Compra";
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

       Compra resultado = (Compra) em.createNamedQuery("Compra.findByIdCompra").setParameter("idCompra", id).getSingleResult();
        assertEquals(reg2.getIdCompra(), resultado.getIdCompra());
        assertEquals(reg2.getIdSucursal(), resultado.getIdSucursal());
    }
}
