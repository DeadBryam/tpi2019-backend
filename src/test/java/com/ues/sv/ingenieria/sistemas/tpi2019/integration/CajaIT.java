/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author lordbryan
 */
public class CajaIT extends AbstractIT<Caja>{

    @Override
    public AbstractFacade<Caja> getFacade() {
        return new CajaFacade();
    }

    @Override
    public Caja getEntity() {
        return new Caja(1);
    }

    @Override
    public String name() {
        return "Caja";
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

       Caja resultado = (Caja) em.createNamedQuery("Caja.findByIdCaja").setParameter("idCaja", id).getSingleResult();
        assertEquals(reg2.getCaja(), resultado.getCaja());
        assertEquals(reg2.getIdCaja(), resultado.getIdCaja());
    }
}
