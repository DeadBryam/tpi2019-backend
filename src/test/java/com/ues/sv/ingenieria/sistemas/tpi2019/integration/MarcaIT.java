/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MarcaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Marca;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Marca;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class MarcaIT extends AbstractIT<Marca>{

    @Override
    public AbstractFacade<Marca> getFacade() {
       return new MarcaFacade();
    }

    @Override
    public Marca getEntity() {
        return new Marca(1);
    }

    @Override
    public String name() {
        return "Marca";
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

       Marca resultado = (Marca) em.createNamedQuery("Marca.findByIdMarca").setParameter("idMarca", id).getSingleResult();
        assertEquals(reg2.getMarca(), resultado.getMarca());
        assertEquals(reg2.getIdMarca(), resultado.getIdMarca());
    }
}
