/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class KardexIT extends AbstractIT<Kardex>{

    @Override
    public AbstractFacade<Kardex> getFacade() {
       return new KardexFacade();
    }

    @Override
    public Kardex getEntity() {
        return new Kardex(1);
    }

    @Override
    public String name() {
        return "Kardex";
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

       Kardex resultado = (Kardex) em.createNamedQuery("Kardex.findByIdKardex").setParameter("idKardex", id).getSingleResult();
        assertEquals(reg2.getIdKardex(), resultado.getIdKardex());
        assertEquals(reg2.getPrecioActual(), resultado.getPrecioActual());
    }
    
}
