/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Compra;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class AbastecimientoBeanTest implements Serializable{

    ArticuloFacade artFacade = mock(ArticuloFacade.class);

    AbastecimientoBean abasmock = mock(AbastecimientoBean.class);
    Articulo articulo = mock(Articulo.class);
    Kardex kardex = mock(Kardex.class);
    List<Kardex> lis = new ArrayList<>();
    Compra compra = mock(Compra.class);

    @Before
    public void init() {
        kardex = new Kardex(1);
        articulo = new Articulo("1");
        compra=new Compra(1);
        Whitebox.setInternalState(abasmock, "articuloFacade", artFacade);
        doCallRealMethod().when(abasmock).setCompra(any(Compra.class));
        doCallRealMethod().when(abasmock).setArticulo(any(Articulo.class));
        doCallRealMethod().when(abasmock).setKardex(any(Kardex.class));
        doCallRealMethod().when(abasmock).setAbastecimientoList(any(List.class));
        doCallRealMethod().when(abasmock).getAbastecimientoList();
        doCallRealMethod().when(abasmock).getKardex();
        doCallRealMethod().when(abasmock).getArticulo();
        lis.add(new Kardex(1));
        lis.add(new Kardex(1));
        lis.add(new Kardex(1));
    }

    @Test
    public void articuloCompletoTest() {
        doCallRealMethod().when(abasmock).articuloCompleto(any(String.class));
        doCallRealMethod().when(abasmock).onDeselectArticulo();
        doCallRealMethod().when(abasmock).onDeselectKardex();
        doCallRealMethod().when(abasmock).onSelectArticulo(any(Articulo.class));
        doCallRealMethod().when(abasmock).onSelectKardex(any(Kardex.class));

        String resultado;
        String id = "1";

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
    public void set() {
        doCallRealMethod().when(abasmock).setBtnEdit(true);
        doCallRealMethod().when(abasmock).init();
        abasmock.setAbastecimientoList(lis);
        abasmock.setArticulo(articulo);
        abasmock.setCompra(compra);
        abasmock.setBtnEdit(true);
        abasmock.setKardex(kardex);
        abasmock.init();
    }

    @Test
    public void get() {
        doCallRealMethod().when(abasmock).getCompra();
        doCallRealMethod().when(abasmock).getBtnEdit();
        when(abasmock.getCompra()).thenReturn(compra);
        when(abasmock.getAbastecimientoList()).thenReturn(lis);
        when(abasmock.getArticulo()).thenReturn(articulo);
        when(abasmock.getKardex()).thenReturn(kardex);
        when(abasmock.getBtnEdit()).thenReturn(Boolean.TRUE);

        assertEquals(3, abasmock.getAbastecimientoList().size());

        assertEquals(kardex, abasmock.getKardex());
        assertEquals(compra, abasmock.getCompra());

        assertEquals(articulo, abasmock.getArticulo());

        assertTrue(abasmock.getBtnEdit());
    }

    @Test
    public void eliminarFacturacionTest() {
        doCallRealMethod().when(abasmock).eliminarFacturacion();
        lis.clear();
        kardex.setIdArticulo(articulo);
        kardex.setIdArticulo(articulo);
        kardex.setIdArticulo(articulo);
        lis.add(0, kardex);
        lis.add(1, kardex);
        lis.add(2, kardex);
        abasmock.setArticulo(articulo);
        abasmock.setAbastecimientoList(lis);
        abasmock.setKardex(kardex);
        abasmock.eliminarFacturacion();

    }

    @Test
    public void addTest() {
        doCallRealMethod().when(abasmock).add();
        lis.clear();
        articulo.setPrecio(BigDecimal.ONE);
        kardex.setIdArticulo(articulo);
        kardex.setCantidad(3);

        lis.add(0, kardex);
        lis.add(1, kardex);
        lis.add(2, kardex);

        abasmock.setArticulo(articulo);
        abasmock.setKardex(kardex);
        abasmock.setAbastecimientoList(lis);
        abasmock.add();
    }

    @Test
    public void crearTest() {
        CompraFacade compraFacade = mock(CompraFacade.class);
        KardexFacade kardexFacade= mock(KardexFacade.class);
        Whitebox.setInternalState(abasmock, "compraFacade", compraFacade);
        Whitebox.setInternalState(abasmock, "kardexFacade", kardexFacade);
        doCallRealMethod().when(abasmock).crear();
        when(compraFacade.crear(compra)).thenReturn(compra);
        abasmock.setCompra(compra);
        abasmock.setAbastecimientoList(lis);
        abasmock.crear();
    }
}
