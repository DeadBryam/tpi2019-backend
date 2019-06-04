/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Medida;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Medida;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class MedidaIT extends AbstractIT<Medida>{

   @Override
    public AbstractFacade<Medida> getFacade() {
       return new MedidaFacade();
    }

    @Override
    public Medida getEntity() {
        return new Medida(1);
    }

    @Override
    public String name() {
        return "Medida";
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

       Medida resultado = (Medida) em.createNamedQuery("Medida.findByIdMedida").setParameter("idMedida", id).getSingleResult();
        assertEquals(reg2.getMedida(), resultado.getMedida());
        assertEquals(reg2.getIdMedida(), resultado.getIdMedida());
    }
}
