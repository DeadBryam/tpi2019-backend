/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Venta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author arevalo
 */
//@RunWith(value= PowerMockRunner.class)
public class FacturacionBeanTest implements Serializable{

    FacturacionBean bean = mock(FacturacionBean.class);
    Venta venta = mock(Venta.class);
    Kardex kardex = mock(Kardex.class);
    List<Kardex> listKardex = new ArrayList<>();
    List<Bodega> listBodega = new ArrayList<>();
    ArticuloFacade articuloFacade = mock(ArticuloFacade.class);
    Articulo articulo = mock(Articulo.class);

    @Before
    public void init() {
        kardex = new Kardex(1);
        articulo = new Articulo("1");
        Whitebox.setInternalState(bean, "articuloFacade", articuloFacade);
        doCallRealMethod().when(bean).setVenta(any(Venta.class));
        doCallRealMethod().when(bean).setFacturacionList(any(List.class));
        doCallRealMethod().when(bean).setKardex(any(Kardex.class));
        doCallRealMethod().when(bean).getFacturacionList();
        doCallRealMethod().when(bean).getKardex();
        doCallRealMethod().when(bean).setArticulo(any(Articulo.class));
        doCallRealMethod().when(bean).getArticulo();
        listBodega.add(new Bodega());
        listBodega.add(new Bodega());
        listBodega.add(new Bodega());
        listKardex.add(new Kardex(1));
        listKardex.add(new Kardex(1));
        listKardex.add(new Kardex(1));
    }

    @Test
    public void metodosOn() {
        when(articuloFacade.findById("APA1245")).thenReturn(articulo);
        doCallRealMethod().when(bean).onSelectArticulo(any(String.class));
        doCallRealMethod().when(bean).init();
        doCallRealMethod().when(bean).cancelar();
        doCallRealMethod().when(bean).onDeselectArticulo();
        doCallRealMethod().when(bean).onDeselectKardex();
        doCallRealMethod().when(bean).onSelectKardex(any(Kardex.class));

        bean.cancelar();
        bean.init();
        bean.onDeselectArticulo();
        bean.onDeselectKardex();
        bean.onSelectArticulo("APA1245");
        verify(articuloFacade).findById("APA1245");
        bean.onSelectKardex(kardex);

    }

    @Test
    public void set() {
        doCallRealMethod().when(bean).setBodegaList(any(List.class));
        doCallRealMethod().when(bean).setBtnEdit(any(Boolean.class));

        bean.setBtnEdit(true);
        bean.setBodegaList(listBodega);
        bean.setFacturacionList(listKardex);
        bean.setKardex(kardex);
        bean.setVenta(venta);

    }

    @Test
    public void gets() {
        doCallRealMethod().when(bean).getBtnEdit();
        doCallRealMethod().when(bean).getBodegaList();
        doCallRealMethod().when(bean).getVenta();
        when(bean.getBtnEdit()).thenReturn(true);
        when(bean.getBodegaList()).thenReturn(listBodega);
        when(bean.getFacturacionList()).thenReturn(listKardex);
        when(bean.getKardex()).thenReturn(kardex);
        when(bean.getVenta()).thenReturn(venta);
        when(bean.getArticulo()).thenReturn(articulo);

        assertEquals(3, bean.getBodegaList().size());

        assertEquals(3, bean.getFacturacionList().size());

        assertTrue(bean.getBtnEdit());

        assertEquals(venta, bean.getVenta());

        assertEquals(kardex, bean.getKardex());
        assertEquals(articulo, bean.getArticulo());

    }

    @Test
    public void onChange() {
        BodegaFacade bodegaFacade = mock(BodegaFacade.class);
        Whitebox.setInternalState(bean, "bodegaFacade", bodegaFacade);
        doCallRealMethod().when(bean).onChange();
        when(bodegaFacade.bodegaPorSucursal(any(String.class))).thenReturn(listBodega);
        when(venta.getIdSucursal()).thenReturn("200IQ");
        bean.setVenta(venta);
        bean.onChange();

        when(venta.getIdSucursal()).thenReturn("");
        bean.onChange();
    }

    @Test
    public void eliminarFacturacionTest() {
        doCallRealMethod().when(bean).eliminarFacturacion();
        listKardex.clear();
        kardex.setIdArticulo(articulo);
        kardex.setIdArticulo(articulo);
        kardex.setIdArticulo(articulo);
        listKardex.add(0, kardex);
        listKardex.add(1, kardex);
        listKardex.add(2, kardex);
        bean.setArticulo(articulo);
        bean.setFacturacionList(listKardex);
        bean.setKardex(kardex);
        bean.eliminarFacturacion();

    }

    @Test
    public void addTest() {
        doCallRealMethod().when(bean).add();
        articulo.setPrecio(BigDecimal.ONE);
        kardex.setIdArticulo(articulo);
        kardex.setCantidad(3);
        
        listKardex.add(0, kardex);
        listKardex.add(1, kardex);
        listKardex.add(2, kardex);
        
        bean.setArticulo(articulo);
        bean.setKardex(kardex);
        bean.setFacturacionList(listKardex);
        bean.add();
        
    }
    
    @Test
    public void crearTest() {
        VentaFacade ventaFacade = mock(VentaFacade.class);
        KardexFacade kardexFacade= mock(KardexFacade.class);
        Whitebox.setInternalState(bean, "ventaFacade", ventaFacade);
        Whitebox.setInternalState(bean, "kardexFacade", kardexFacade);
        doCallRealMethod().when(bean).crear();
        when(ventaFacade.crear(venta)).thenReturn(venta);
        bean.setVenta(venta);
        bean.setFacturacionList(listKardex);
        bean.crear();
    }
}
