/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Distribuidor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Selection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author bryan
 */
public class DistribuidorFacadeTest {

    private final DistribuidorFacade cut = new DistribuidorFacade();
    private final Distribuidor esperado = new Distribuidor(Short.parseShort("1"));
    private Distribuidor resultado;
    private EntityManager em;
    private List<Distribuidor> lstEsperado;

    @Before
    public void init() {
        em = Mockito.mock(EntityManager.class);
        //cut.em = this.em;
        Whitebox.setInternalState(cut, "em", em);
     
    }

    @Test(expected = Exception.class)
    public void testFindById(){
        System.out.println("testFindById");
        //Whitebox.setInternalState(cut, "em", ema);

        Mockito.when(this.em.find(Distribuidor.class, 1)).thenReturn(esperado);

        resultado = cut.findById(1);
        assertEquals(esperado, resultado);

        resultado = cut.findById(null);
        assertNull(resultado);
            
        new DistribuidorFacade().findById("error"); 
    }
    
    @Test
    public void testFindAll(){
        System.out.println("testFindAll");
        List<Distribuidor> lstResultado;
        
        CriteriaBuilder CB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery CQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery q = Mockito.mock(TypedQuery.class);
        
        Mockito.when(this.em.getCriteriaBuilder()).thenReturn(CB);
        Mockito.when(CB.createQuery()).thenReturn(CQ);
        Mockito.when(CQ.select(Matchers.any(Selection.class))).thenReturn(CQ);
        Mockito.when(this.em.createQuery(CQ)).thenReturn(q);
        Mockito.when(q.getResultList()).thenReturn(lstEsperado);
        
        lstResultado = cut.findAll();
        
        assertEquals(lstResultado, lstEsperado);
        
    }
    
    @Test
    public void testCreate(){
        
        
    }
}
