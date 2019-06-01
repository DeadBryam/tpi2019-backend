/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class CajaFacadeTest extends AbstractTest<Caja>{
    CajaFacade cf;
    Query query = Mockito.mock(Query.class);
    List<Caja> list= new ArrayList<>();
      
    @Override
    protected AbstractFacade<Caja> getFacade() {
       return new CajaFacade();
    }

    @Override
    protected Caja getEntity() {
        return new Caja(1);
    }
    
    @Override
    public  void init(){
        super.init();
        cf = new CajaFacade();
        list.add(new Caja(1));
        list.add(new Caja(1));
        list.add(new Caja(1));
        query.setFirstResult(1);
    }
    
    boolean ver=true;
    @Test
    public void CajaExistsTest(){
        Whitebox.setInternalState(cf, "em", em);
        Mockito.when(cut.executeQuery("SELECT COUNT(c) FROM Caja c WHERE c.idCaja = :idCaja")).thenReturn(query);
        Mockito.when(query.setParameter(Matchers.any(String.class), Matchers.any(Integer.class))).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(list);
        Mockito.when(query.getSingleResult().toString().equals("1")).thenReturn(ver);
        assertNotNull(cf.cajaExist(1));
    }
}
