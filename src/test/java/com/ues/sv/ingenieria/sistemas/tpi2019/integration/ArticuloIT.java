/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class ArticuloIT extends AbstractIT<Articulo>{

    @Override
    public AbstractFacade<Articulo> getFacade() {
       return new ArticuloFacade();
    }

    @Override
    public Articulo getEntity() {
        return new Articulo("1");
    }

    @Override
    public String name() {
        return "Articulo";
    }

    @Override
    public Object Id() {
        return "1";
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

       Articulo resultado = (Articulo) em.createNamedQuery("Articulo.findByIdArticulo").setParameter("idArticulo", id).getSingleResult();
        assertEquals(reg2.getArticulo(), resultado.getArticulo());
        assertEquals(reg2.getPrecio(), resultado.getPrecio());
    }
}
