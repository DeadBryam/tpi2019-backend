/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class SucursalFacadeTest extends AbstractTest<Sucursal>{
    SucursalFacade sf;
    Query query = Mockito.mock(Query.class);
    List<Sucursal> list= new ArrayList<>();
    
    @Override
    protected AbstractFacade<Sucursal> getFacade() {
        return new SucursalFacade();
    }

    @Override
    protected Sucursal getEntity() {
        return new Sucursal("1");
    }
    
    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        sf= new SucursalFacade();
        list.add(new Sucursal("1"));
        list.add(new Sucursal("1"));
        list.add(new Sucursal("1"));
        query.setFirstResult(1);
    }
    boolean ver=true;
    boolean pr;
    @Test
    public void findLikeTest(){
        Whitebox.setInternalState(sf, "em", em);
        Mockito.when(cut.executeQuery("SELECT COUNT(s) FROM Sucursal s WHERE s.idSucursal = :idSucursal")).thenReturn(query);
        Mockito.when(query.setParameter(Matchers.any(String.class), Matchers.any(Integer.class))).thenReturn(query);
        System.out.println("query : "+query.getResultList());
        Mockito.when(query.getSingleResult()).thenReturn(list);
        Mockito.when(query.getSingleResult().toString().equals("1")).thenReturn(ver);
        assertNotNull(sf.sucursalExists("APA1245"));
    }
    
}
