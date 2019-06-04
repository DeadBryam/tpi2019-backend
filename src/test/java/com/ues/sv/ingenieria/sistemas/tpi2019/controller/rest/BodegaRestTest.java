/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class BodegaRestTest {
    BodegaFacade bodegaFacade= mock(BodegaFacade.class);
    BodegaRest bodegaRest =mock(BodegaRest.class);
    List<Bodega> listaBodega=new ArrayList<>();
    SucursalFacade sucursalFacade=mock(SucursalFacade.class);
   // Bodega bodega=mock(Bodega.class);
    @Before
    public void init(){
        Whitebox.setInternalState(bodegaRest, "bodegaFacade", bodegaFacade);
        Whitebox.setInternalState(bodegaRest, "sucursalFacade", sucursalFacade);
        listaBodega.add(new Bodega());
        listaBodega.add(new Bodega());
        listaBodega.add(new Bodega());
    }
    
    @Test
    public void findRangeTest(){
        doCallRealMethod().when(bodegaRest).findLike(any(String.class));
        when(sucursalFacade.sucursalExists(any(String.class))).thenReturn(Boolean.TRUE);
        when(bodegaFacade.findRange(any(Integer.class),any(Integer.class))).thenReturn(listaBodega);
        when(bodegaFacade.count()).thenReturn(listaBodega.size());
        
        assertEquals(200,bodegaRest.findLike("").getStatus());
        
    }
    
    @Test
    public void finAll(){
        doCallRealMethod().when(bodegaRest).findAll();
        when(bodegaFacade.bodegaPorSucursal(any(String.class))).thenReturn(listaBodega);
        when(sucursalFacade.sucursalExists(any(String.class))).thenReturn(Boolean.TRUE);
        
        assertEquals(200, bodegaRest.findAll().getStatus());
    }
    
}
