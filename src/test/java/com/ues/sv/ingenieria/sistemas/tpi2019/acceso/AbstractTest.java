/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Selection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.internal.util.reflection.Whitebox;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;

/**
 *
 * @author arevalo
 * @param <T>
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractTest<T> {

    @Mock
    private EntityManager em;

    protected abstract AbstractFacade<T> getFacade();

    protected abstract T getEntity();
    AbstractFacade<T> cut = getFacade();
    T entity;
    
    private final CriteriaBuilder CB = mock(CriteriaBuilder.class);
    private final CriteriaQuery CQ = mock(CriteriaQuery.class);
    private final TypedQuery q = mock(TypedQuery.class);
    private List<T> lstEsperado;
    private List<T> lstResultado;

    @Before
    public void init() {
        entity = getEntity();
        Whitebox.setInternalState(cut, "em", em);
        when(this.em.getCriteriaBuilder()).thenReturn(CB);
        when(CB.createQuery()).thenReturn(CQ);
        when(CQ.select(Matchers.any(Selection.class))).thenReturn(CQ);
        when(this.em.createQuery(CQ)).thenReturn(q);
        when(q.getResultList()).thenReturn(lstEsperado);

    }

    @Test
    public void testCreate() {
        cut.create(entity);
        verify(em).persist(entity);
    }
    
    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test
    public void testEdit() {
        cut.edit(entity);
        verify(em).merge(entity);

        //cut.edit(null);
    }

    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test
    public void testRemove() {
        cut.remove(entity);
        verify(em).remove(em.merge(entity));
    }

    /**
     * Test of findById method, of class AbstractFacade.
     */
    @Test
    public void testFindById() {
        System.out.println("testFindById");
        when(this.em.find(entity.getClass(),1)).thenReturn(entity);
       T resultado = cut.findById(1);
        assertEquals(entity, resultado);
        resultado = cut.findById(null);
        
        assertNull(resultado);
    }

    /**
     * Test of findAll method, of class AbstractFacade.
     */
    @Test
    public void testFindAll() {
        System.out.println("testFindAll");
        lstResultado = cut.findAll();
        assertEquals(lstResultado, lstEsperado);
    }

    /**
     * Test of findRange method, of class AbstractFacade.
     */
    @Test
    public void testFindRange() {
        System.out.println("testFindRange");
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
