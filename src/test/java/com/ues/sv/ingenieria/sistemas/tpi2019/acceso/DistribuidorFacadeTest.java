/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Distribuidor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Selection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author bryan
 */
public class DistribuidorFacadeTest {

    private final DistribuidorFacade cut = new DistribuidorFacade();
    private final DistribuidorFacade nor = new DistribuidorFacade();
    private final Distribuidor esperado = new Distribuidor(Short.parseShort("1"));
    private final CriteriaBuilder CB = mock(CriteriaBuilder.class);
    private final CriteriaQuery CQ = mock(CriteriaQuery.class);
    private final TypedQuery q = mock(TypedQuery.class);
    private Distribuidor resultado;
    private EntityManager em;
    private List<Distribuidor> lstEsperado;

    @Before
    public void init() {
        em = mock(EntityManager.class);
        Whitebox.setInternalState(cut, "em", em);

        when(this.em.getCriteriaBuilder()).thenReturn(CB);
        when(CB.createQuery()).thenReturn(CQ);
        when(CQ.select(Matchers.any(Selection.class))).thenReturn(CQ);
        when(this.em.createQuery(CQ)).thenReturn(q);

    }

    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test(expected = Exception.class)
    public void testCreate() {
        cut.create(esperado);
        verify(em).persist(esperado);

        cut.create(null);

        nor.create(esperado);
    }

    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test(expected = Exception.class)
    public void testEdit() {
        cut.edit(esperado);
        verify(em).merge(esperado);

        cut.edit(null);

        nor.edit(esperado);
    }

    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test(expected = Exception.class)
    public void testRemove() {
        cut.remove(esperado);
        verify(em).remove(em.merge(esperado));

        cut.remove(null);

        nor.remove(esperado);
    }

    /**
     * Test of findById method, of class AbstractFacade.
     */
    @Test(expected = Exception.class)
    public void testFindById() {
        System.out.println("testFindById");

        when(this.em.find(Distribuidor.class, 1)).thenReturn(esperado);

        resultado = cut.findById(1);
        assertEquals(esperado, resultado);

        resultado = cut.findById(null);
        assertNull(resultado);

        nor.findById("error");
    }

    /**
     * Test of findAll method, of class AbstractFacade.
     */
    @Test
    public void testFindAll() {
        System.out.println("testFindAll");
        List<Distribuidor> lstResultado;

        when(q.getResultList()).thenReturn(lstEsperado);
        lstResultado = cut.findAll();

        assertEquals(lstResultado, lstEsperado);
    }

    /**
     * Test of findRange method, of class AbstractFacade.
     */
    @Test
    public void testFindRange() {
        System.out.println("testFindRange");
        List<Distribuidor> lstResultado;

        when(q.getResultList()).thenReturn(lstEsperado);
        lstResultado = cut.findRange(0, 100);

        assertEquals(lstResultado, lstEsperado);
    }

    /**
     * Test of count method, of class AbstractFacade.
     */
    @Test
    public void testCount() {
        System.err.println("testCount");
        int res;

        when(q.getSingleResult()).thenReturn((Long) 0l);
        res = cut.count();

        assertEquals(0, res);
    }

}
