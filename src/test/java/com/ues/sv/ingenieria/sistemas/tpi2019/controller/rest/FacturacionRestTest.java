/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
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
public class FacturacionRestTest {

    CajaFacade cajaFacade = mock(CajaFacade.class);
    SucursalFacade sucursalFacade=mock(SucursalFacade.class);
    FacturacionRest facturacionRest= mock(FacturacionRest.class);
    List<Caja> listCaja=new ArrayList<>();
    Caja caja=mock(Caja.class);
    
    @Before
    public void init(){
        Whitebox.setInternalState(facturacionRest, "cajaFacade", cajaFacade);
        Whitebox.setInternalState(facturacionRest, "sucursalFacade", sucursalFacade);
        caja= new Caja(1);
        when(sucursalFacade.sucursalExists(any(String.class))).thenReturn(Boolean.TRUE);
        listCaja.add(caja);
        listCaja.add(caja);
        listCaja.add(caja);
        listCaja.add(caja);
    }
    
    @Test
    public void findRange(){
        doCallRealMethod().when(facturacionRest).findRange(any(Integer.class),any(Integer.class));
        when(cajaFacade.findRange(any(Integer.class),any(Integer.class))).thenReturn(listCaja);
        when(cajaFacade.count()).thenReturn(listCaja.size());
        
        assertEquals(200, facturacionRest.findRange(0,3).getStatus());
        
    }
    
    @Test
    public void finById(){
        doCallRealMethod().when(facturacionRest).findById(any(Integer.class));
        when(cajaFacade.findById(any(Object.class))).thenReturn(caja);
        
        assertEquals(200, facturacionRest.findById(3).getStatus());
    }
    
    @Test
    public void create(){
        doCallRealMethod().when(facturacionRest).create(any(Caja.class));
        when(cajaFacade.create(any(Caja.class))).thenReturn(caja);
        
        assertEquals(201, facturacionRest.create(caja).getStatus());
    }

}
