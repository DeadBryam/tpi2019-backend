/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author lordbryan
 */
public class CajaIT {
    CajaFacade facade;
    EntityManager em;
    Caja entity;
    EntityTransaction et;
    
    @Before
    public void setUp() {
        em = Persistence.createEntityManagerFactory("libreria-test").createEntityManager();
    }
    
    @Test
    public void testCreate(){
        entity = new Caja(1);
        facade = new CajaFacade();
        Whitebox.setInternalState(facade, "em", em);
        et = em.getTransaction();
        em.setFlushMode(FlushModeType.AUTO);
        et.begin();
        facade.create(entity);
        et.commit();
        
        Assert.assertEquals(1,facade.findAll().size());
    }
}
