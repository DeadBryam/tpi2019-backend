/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.TipoMedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoMedida;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoMedida;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class tipoMedidaIT extends AbstractIT<TipoMedida>{

 @Override
    public AbstractFacade<TipoMedida> getFacade() {
       return new TipoMedidaFacade();
    }

    @Override
    public TipoMedida getEntity() {
        return new TipoMedida(1);
    }

    @Override
    public String name() {
        return "TipoMedida";
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

       TipoMedida resultado = (TipoMedida) em.createNamedQuery("TipoMedida.findByIdTipoMedida").setParameter("idTipoMedida", id).getSingleResult();
        assertEquals(reg2.getTipoMedida(), resultado.getTipoMedida());
        assertEquals(reg2.getTipoMedida(), resultado.getTipoMedida());
    }
    
}
