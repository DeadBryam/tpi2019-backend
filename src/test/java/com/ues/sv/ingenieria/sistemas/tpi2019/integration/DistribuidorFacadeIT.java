/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Distribuidor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author bryan
 */
public class DistribuidorFacadeIT extends AbstractIT<Distribuidor>{

    public DistribuidorFacadeIT() {
    }

//    /**
//     * Test of edit method, of class DistribuidorFacade.
//     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit-IT");
//
//        et.begin();
//        cut.create(reg1);
//        et.commit();
//        em.detach(reg1);
//
//        et.begin();
//        cut.edit(reg2);
//        et.commit();
//
//        Distribuidor resultado = (Distribuidor) em.createNamedQuery("Distribuidor.findByIdDistribuidor").setParameter("idDistribuidor", id).getSingleResult();
//        assertEquals(reg2.getDistribuidor(), resultado.getDistribuidor());
//        assertEquals(reg2.getTelefono(), resultado.getTelefono());
//    }

    @Override
    public AbstractFacade<Distribuidor> getFacade() {
        return new DistribuidorFacade();
    }

    @Override
    public Distribuidor getEntity() {
        return new Distribuidor("1");
    }

    @Override
    public String name() {
        return "Distribuidor";
    }

    @Override
    public Object Id() {
        return "1";
    }
}
