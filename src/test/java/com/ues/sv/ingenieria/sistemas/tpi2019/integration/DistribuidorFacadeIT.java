/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

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
public class DistribuidorFacadeIT {

    public DistribuidorFacadeIT() {
    }

    private EntityManager em;
    private final String id = "DIZ124";
    private final Distribuidor reg1 = new Distribuidor(id, "juanito", 79797104);
    private final Distribuidor reg2 = new Distribuidor(id, "pedrito", 78787865);
    private final DistribuidorFacade cut = new DistribuidorFacade();
    List<Distribuidor> lst;
    private EntityTransaction et;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        em = Persistence.createEntityManagerFactory("libreria-test").createEntityManager();
        Whitebox.setInternalState(cut, "em", em);
        et = em.getTransaction();
        em.setFlushMode(FlushModeType.AUTO);
    }

    @After
    public void tearDown() {
        em.clear();

        et.begin();
        em.createQuery("DELETE FROM Distribuidor").executeUpdate();
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

        Distribuidor resultado = (Distribuidor) em.createNamedQuery("Distribuidor.findByIdDistribuidor").setParameter("idDistribuidor", id).getSingleResult();
        assertNotNull(resultado);
        assertEquals(1, cut.count());
    }

    /**
     * Test of edit method, of class DistribuidorFacade.
     */
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

        Distribuidor resultado = (Distribuidor) em.createNamedQuery("Distribuidor.findByIdDistribuidor").setParameter("idDistribuidor", id).getSingleResult();
        assertEquals(reg2.getDistribuidor(), resultado.getDistribuidor());
        assertEquals(reg2.getTelefono(), resultado.getTelefono());
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

        lst = em.createNamedQuery("Distribuidor.findAll").getResultList();
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
