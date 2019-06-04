/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public abstract class AbstractIT<T> implements Serializable{
    EntityManager em;
    
    public abstract AbstractFacade<T> getFacade();
    public abstract T getEntity();
    public abstract String name();
    public abstract Object Id();
    T reg1;
    T reg2;
    AbstractFacade<T> cut= getFacade();
    EntityTransaction et;
    String name= name();
    Object id=Id();
    List<T> lst;
    //esto es algo 
    @Before
    public void setUp() {
        reg1= getEntity();
        reg2=getEntity();
        em = Persistence.createEntityManagerFactory("libreria-test").createEntityManager();
        Whitebox.setInternalState(cut, "em", em);
        et = em.getTransaction();
        em.setFlushMode(FlushModeType.AUTO);
    }

    @After
    public void tearDown() {
        em.clear();

        et.begin();
        em.createQuery("DELETE FROM "+name).executeUpdate();
        et.commit();
    }

    /**
     * Test of create method, of class DistribuidorFacade.
     */
    @Test
    public void testCreate() {
        System.out.println("create-IT");

        et.begin();
        cut.create(reg1);
        et.commit();

        T resultado = (T) em.createNamedQuery(name+".findById"+name).setParameter("id"+name, id).getSingleResult();
        assertNotNull(resultado);
        assertEquals(1, cut.count());
    }

    /**
     * Test of remove method, of class DistribuidorFacade.
     */
    @Test
    public void testRemove() {
        System.out.println("remove-IT");

        et.begin();
        cut.create(reg1);
        cut.remove(reg1);
        et.commit();

        lst = em.createNamedQuery(name+".findAll").getResultList();
        assertEquals(0, lst.size());
    }

    /**
     * Test of findById method, of class DistribuidorFacade.
     */
    @Test
    public void testFindById() {
        System.out.println("findById - IT");

        et.begin();
        cut.create(reg1);
        et.commit();

        //assertEquals(cut.findById(id), reg1);
        assertTrue(cut.findById(id).equals(reg1));
    }

    /**
     * Test of findAll method, of class DistribuidorFacade.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll-IT");

        et.begin();
        cut.create(reg1);
        et.commit();

        lst = cut.findAll();
        assertEquals(1, lst.size());
    }

    /**
     * Test of findRange method, of class DistribuidorFacade.
     */
    @Test
    public void testFindRange() {
        System.out.println("findRange-IT");

        et.begin();
        cut.create(reg1);
        et.commit();

        lst = cut.findRange(0, 1);
        assertEquals(1, lst.size());
    }

    /**
     * Test of count method, of class DistribuidorFacade.
     */
    @Test
    public void testCount() {
        System.out.println("count-IT");
        int result;

        et.begin();
        cut.create(reg1);
        et.commit();

        result = cut.count();
        assertEquals(1, result);
    }
    
}
