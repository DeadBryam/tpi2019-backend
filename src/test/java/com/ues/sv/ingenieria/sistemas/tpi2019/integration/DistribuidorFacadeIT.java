/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Distribuidor;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author bryan
 */
public class DistribuidorFacadeIT {

    public DistribuidorFacadeIT() {
    }

    private EntityManager em;
    private final Short id = 1;
    private final Distribuidor reg1 = new Distribuidor(id, "juanito", "79797104");
    private final Distribuidor reg2 = new Distribuidor(id, "pedrito", "79797104");
    private final DistribuidorFacade cut = new DistribuidorFacade();
    private EntityTransaction et;

//    @Rule
//    public EntityManagerProvider emp = EntityManagerProvider.getInstance("libreria-test", cut);
    
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

        et.begin();
        //emp.getTransaction().begin();
    }

    @After
    public void tearDown() {
        et.rollback();
      // emp.getTransaction().rollback();
    }
    
//    public AbstractFacade facade(){
//        return emp.getFacade();
//    }

    /**
     * Test of create method, of class DistribuidorFacade.
     */
    @Test
    public void testCreate() {
        System.out.println("create-IT");

        cut.create(reg1);
        assertNotNull(cut.findById(id));
    }

    /**
     * Test of edit method, of class DistribuidorFacade.
     */
    @Test
    public void testEdit() {
        System.out.println("edit-IT");

       cut.create(reg1);
        cut.edit(reg2);
        assertEquals(reg1, cut.findById(id));
    }

    /**
     * Test of remove method, of class DistribuidorFacade.
     */
    @Test
    public void testRemove() {
        System.out.println("remove-IT");

        cut.create(reg1);
        cut.remove(reg1);
        assertNull(cut.findById(id));
    }

    /**
     * Test of findById method, of class DistribuidorFacade.
     */
    @Test
    public void testFindById() {
        System.out.println("findById - IT");

        cut.create(reg1);
        assertEquals(cut.findById(id), reg1);
    }

    /**
     * Test of findAll method, of class DistribuidorFacade.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll-IT");

        cut.create(reg1);
        List lst = cut.findAll();
        assertEquals(1, lst.size());
    }

    /**
     * Test of findRange method, of class DistribuidorFacade.
     */
    @Test
    public void testFindRange() {
        System.out.println("findRange-IT");

        cut.create(reg1);
        List lst = cut.findRange(0, 1);
        assertEquals(1, lst.size());
    }

    /**
     * Test of count method, of class DistribuidorFacade.
     */
    @Test
    public void testCount() {
        System.out.println("count-IT");
        int result;

        cut.create(reg1);
        result = cut.count();
        assertEquals(1, result);
    }
}
