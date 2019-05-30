/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Compra;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class AbastecimientoBeanTest {
    ArticuloFacade artFacade= mock(ArticuloFacade.class);
    
    AbastecimientoBean abasmock= mock(AbastecimientoBean.class);
    Articulo articulo = mock(Articulo.class);
    Kardex kardex = mock(Kardex.class);
    List<Kardex> lis=new ArrayList<>();
    Compra compra=mock(Compra.class);
    
    @Before
    public void init(){
        Whitebox.setInternalState(abasmock, "articuloFacade", artFacade);
        doCallRealMethod().when(abasmock).articuloCompleto(any(String.class));
        doCallRealMethod().when(abasmock).onDeselectArticulo();
        doCallRealMethod().when(abasmock).onDeselectKardex();
        doCallRealMethod().when(abasmock).setBtnEdit(any(Boolean.class));
        doCallRealMethod().when(abasmock).onSelectArticulo(articulo);
        doCallRealMethod().when(abasmock).onSelectKardex(kardex);
        lis.add(new Kardex(1));
        lis.add(new Kardex(1));
        lis.add(new Kardex(1));
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
        
        abasmock.onDeselectKardex();
        verify(abasmock).setBtnEdit(false);
        
        abasmock.onDeselectArticulo();
        
        abasmock.onSelectArticulo(articulo);
        abasmock.onSelectKardex(kardex);
    }
    
    @Test
    public void getandset(){
        when(abasmock.getCompra()).thenReturn(compra);
        doCallRealMethod().when(abasmock).getCompra();
        doCallRealMethod().when(abasmock).setCompra(compra);
        when(abasmock.getAbastecimientoList()).thenReturn(lis);
        doCallRealMethod().when(abasmock).getAbastecimientoList();
        doCallRealMethod().when(abasmock).setAbastecimientoList(lis);
        when(abasmock.getArticulo()).thenReturn(articulo);
        doCallRealMethod().when(abasmock).getArticulo();
        doCallRealMethod().when(abasmock).setArticulo(articulo);
        when(abasmock.getKardex()).thenReturn(kardex);
        doCallRealMethod().when(abasmock).getKardex();
        doCallRealMethod().when(abasmock).setKardex(kardex);
        doCallRealMethod().when(abasmock).getBtnEdit();
        doCallRealMethod().when(abasmock).setBtnEdit(true);
        doCallRealMethod().when(abasmock).init();
        
        abasmock.setAbastecimientoList(lis);
        abasmock.setArticulo(articulo);
        abasmock.setCompra(compra);
        abasmock.setBtnEdit(true);
        abasmock.setKardex(kardex);
        
        assertEquals(3, abasmock.getAbastecimientoList().size());
        
        assertEquals(kardex, abasmock.getKardex());
        assertEquals(compra, abasmock.getCompra());
        
        assertEquals(articulo, abasmock.getArticulo());
        
        assertTrue(abasmock.getBtnEdit());
        abasmock.init();
    }
    

}
