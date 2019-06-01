/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
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
public class HistorialRestTest {
     KardexFacade bodegaFacade= mock(KardexFacade.class);
    HistorialRest bodegaRest =mock(HistorialRest.class);
    List<Kardex> listaKardex=new ArrayList<>();
    SucursalFacade sucursalFacade=mock(SucursalFacade.class);
   // Kardex bodega=mock(Kardex.class);
    @Before
    public void init(){
        Whitebox.setInternalState(bodegaRest, "kardexFacade", bodegaFacade);
        Whitebox.setInternalState(bodegaRest, "sucursalFacade", sucursalFacade);
        listaKardex.add(new Kardex());
        listaKardex.add(new Kardex());
        listaKardex.add(new Kardex());
    }
    
    @Test
    public void findRangeTest(){
        doCallRealMethod().when(bodegaRest).findRange(any(Integer.class),any(Integer.class));
        when(sucursalFacade.sucursalExists(any(String.class))).thenReturn(Boolean.TRUE);
        when(bodegaFacade.findRange(any(Integer.class),any(Integer.class))).thenReturn(listaKardex);
        when(bodegaFacade.count()).thenReturn(listaKardex.size());
        
        assertEquals(200,bodegaRest.findRange(0,2).getStatus());
        
    }
    
}
