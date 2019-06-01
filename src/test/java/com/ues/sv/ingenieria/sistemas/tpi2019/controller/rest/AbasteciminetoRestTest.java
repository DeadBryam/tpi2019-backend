/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.rest;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Distribuidor;
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
public class AbasteciminetoRestTest {
      DistribuidorFacade ditribuidorFacade= mock(DistribuidorFacade.class);
      SucursalFacade sucursalFacade= mock(SucursalFacade.class);
    AbastecimientoREST abastecimientoRest =mock(AbastecimientoREST.class);
    List<Distribuidor> listaAbastecimiento=new ArrayList<>();
    Distribuidor distribuidor=mock(Distribuidor.class);
   // Abastecimiento articulo=mock(Abastecimiento.class);
    @Before
    public void init(){
        Whitebox.setInternalState(abastecimientoRest, "distribuidorFacade", ditribuidorFacade);
        Whitebox.setInternalState(abastecimientoRest, "sucursalFacade", sucursalFacade);
        when(sucursalFacade.sucursalExists(any(String.class))).thenReturn(Boolean.TRUE);
        listaAbastecimiento.add(new Distribuidor());
        listaAbastecimiento.add(new Distribuidor());
        listaAbastecimiento.add(new Distribuidor());
    }
    
    @Test
    public void findTest(){
        doCallRealMethod().when(abastecimientoRest).find(any(Integer.class),any(Integer.class));
        when(ditribuidorFacade.findRange(any(Integer.class),any(Integer.class))).thenReturn(listaAbastecimiento);
        when(ditribuidorFacade.count()).thenReturn(listaAbastecimiento.size());
        
        assertEquals(200,abastecimientoRest.find(0,2).getStatus());
    }
    
    @Test
    public void findById(){
        doCallRealMethod().when(abastecimientoRest).findById(any(String.class));
        when(ditribuidorFacade.findById(any(String.class))).thenReturn(distribuidor);
        
        abastecimientoRest.findById("1");
    }
    
    @Test
    public void createTest(){
        doCallRealMethod().when(abastecimientoRest).create(any(Distribuidor.class));
        when(ditribuidorFacade.create(any(Distribuidor.class))).thenReturn(distribuidor);
        
        assertEquals(201,abastecimientoRest.create(distribuidor).getStatus());
//        assertEquals(Response.status(400,"Missing data."),abastecimientoRest.create(null).getStatus());
        
    }
    
}
