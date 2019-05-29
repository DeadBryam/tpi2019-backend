/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import static org.junit.Assert.*;
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
public class AbastecimientoBeanTest {
    ArticuloFacade artFacade= mock(ArticuloFacade.class);
    
    AbastecimientoBean abasmock= mock(AbastecimientoBean.class);
    
    @Before
    public void init(){
        Whitebox.setInternalState(abasmock, "articuloFacade", artFacade);
        doCallRealMethod().when(abasmock).articuloCompleto(any(String.class));
    }
    
    @Test
    public void articuloCompletoTest(){
        String resultado;
        String id="1";

        resultado = abasmock.articuloCompleto("");
        assertEquals("", resultado);

        when(artFacade.getArticuloCompleto(id)).thenReturn(id);
        resultado = abasmock.articuloCompleto(id);
        assertEquals(id, resultado);
    }

}
