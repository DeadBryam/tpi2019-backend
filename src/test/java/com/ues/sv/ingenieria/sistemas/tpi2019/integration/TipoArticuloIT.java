/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.TipoArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoArticulo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class TipoArticuloIT extends AbstractIT<TipoArticulo>{

    @Override
    public AbstractFacade<TipoArticulo> getFacade() {
       return new TipoArticuloFacade();
    }

    @Override
    public TipoArticulo getEntity() {
        return new TipoArticulo(1);
    }

    @Override
    public String name() {
        return "TipoArticulo";
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

       TipoArticulo resultado = (TipoArticulo) em.createNamedQuery("TipoArticulo.findByIdTipoArticulo").setParameter("idTipoArticulo", id).getSingleResult();
        assertEquals(reg2.getArticuloList(), resultado.getArticuloList());
        assertEquals(reg2.getIdTipoArticulo(), resultado.getIdTipoArticulo());
    }
}
