/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
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
public class SucursalRestTest {
    
    SucursalFacade sucursalFacade=mock(SucursalFacade.class);
    SucursalREST sucursalRest= mock(SucursalREST.class);
    List<Sucursal> listCaja=new ArrayList<>();
    Sucursal sucursal=mock(Sucursal.class);
    
    @Before
    public void init(){
        Whitebox.setInternalState(sucursalRest, "facade", sucursalFacade);
        sucursal= new Sucursal("1");
        when(sucursalFacade.sucursalExists(any(String.class))).thenReturn(Boolean.TRUE);
        listCaja.add(sucursal);
        listCaja.add(sucursal);
        listCaja.add(sucursal);
        listCaja.add(sucursal);
    }
    
    @Test
    public void findRange(){
        doCallRealMethod().when(sucursalRest).find(any(Integer.class),any(Integer.class));
        when(sucursalFacade.findRange(any(Integer.class),any(Integer.class))).thenReturn(listCaja);
        when(sucursalFacade.count()).thenReturn(listCaja.size());
        
        assertEquals(200, sucursalRest.find(0,3).getStatus());
        
    }
    
    @Test
    public void finById(){
        doCallRealMethod().when(sucursalRest).findById(any(String.class));
        when(sucursalFacade.findById(any(Object.class))).thenReturn(sucursal);
        
        assertEquals(200, sucursalRest.findById("3").getStatus());
    }
    
    @Test
    public void create(){
        doCallRealMethod().when(sucursalRest).create(any(Sucursal.class));
        when(sucursalFacade.create(any(Sucursal.class))).thenReturn(sucursal);
        
        assertEquals(201, sucursalRest.create(sucursal).getStatus());
    }
    
}
