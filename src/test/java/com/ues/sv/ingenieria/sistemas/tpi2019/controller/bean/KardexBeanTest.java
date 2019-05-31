/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Compra;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Venta;
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
public class KardexBeanTest extends AbstractBeanTest<Kardex> {

    @Override
    protected AbstractFacade<Kardex> getFacade() {
        return new KardexFacade();
    }

    @Override
    public Kardex getEntity() {
        return new Kardex();
    }

    @Override
    protected AbstractBean<Kardex> getBean() {
        return new KardexBean();
    }

    @Override
    protected String name() {
        return "kardexFacade";
    }

    KardexBean bean = mock(KardexBean.class);
    Kardex k = mock(Kardex.class);
    KardexFacade facade = mock(KardexFacade.class);
    VentaFacade vfacade = mock(VentaFacade.class);
    CompraFacade cfacade = mock(CompraFacade.class);
    Venta venta = mock(Venta.class);
    Compra compra=mock(Compra.class);

    @Before
    public void initAr() {
        k = new Kardex();
        venta = new Venta(1);
        compra=new Compra(1);
        Whitebox.setInternalState(bean, "kardexFacade", facade);
        doCallRealMethod().when(bean).setBtnPedido(any(boolean.class));
        doCallRealMethod().when(bean).setSucursal(any(String.class));
        doCallRealMethod().when(bean).setTipo(any(String.class));
        doCallRealMethod().when(bean).setEstado(any(Boolean.class));
        doCallRealMethod().when(bean).setKardex(any(Kardex.class));
    }

    @Test
    public void onSelectTest() {
        doCallRealMethod().when(bean).onSelect(new Kardex(1));
        doCallRealMethod().when(bean).onDeselect();
        doCallRealMethod().when(bean).init();
        bean.onSelect(new Kardex(1));
        verify(bean).setBtnPedido(true);

        bean.onDeselect();
        verify(bean).setBtnPedido(false);
        bean.init();

        doCallRealMethod().when(bean).onChange();

        bean.setKardex(k);
        bean.setSucursal(id);
        bean.setTipo(id);
        bean.onChange();
    }

    @Test
    public void set() {
        doCallRealMethod().when(bean).setBtnPedido(any(Boolean.class));
        doCallRealMethod().when(bean).cancelar();

        bean.setBtnPedido(true);
        bean.setEstado(true);
        bean.setKardex(k);
        bean.setSucursal(id);
        bean.setTipo(id);
        bean.cancelar();

    }

    @Test
    public void get() {
        doCallRealMethod().when(bean).getEntity();
        doCallRealMethod().when(bean).getFacade();
        doCallRealMethod().when(bean).getKardex();
        doCallRealMethod().when(bean).getSucursal();
        doCallRealMethod().when(bean).getTipo();
        doCallRealMethod().when(bean).isBtnPedido();
        doCallRealMethod().when(bean).isEstado();

        when(bean.getEntity()).thenReturn(k);
        when(bean.getFacade()).thenReturn(facade);
        when(bean.getKardex()).thenReturn(k);
        when(bean.getSucursal()).thenReturn(id);
        when(bean.getTipo()).thenReturn(id);
        when(bean.isBtnPedido()).thenReturn(true);
        when(bean.isEstado()).thenReturn(true);

        assertEquals(k, bean.getEntity());
        assertEquals(k, bean.getKardex());
        assertEquals(facade, bean.getFacade());
        assertEquals(id, bean.getSucursal());
        assertEquals(id, bean.getTipo());
        assertTrue(bean.isBtnPedido());
        assertTrue(bean.isEstado());
    }

    @Test
    public void updateEstadoTest() {
        doCallRealMethod().when(bean).updateEstado();
        Whitebox.setInternalState(bean, "ventaFacade", vfacade);
        k.setIdVenta(venta);
        bean.setKardex(k);
        bean.updateEstado();
        k=new Kardex();
        Whitebox.setInternalState(bean, "compraFacade", cfacade);
        k.setIdCompra(compra);
        bean.setKardex(k);
        bean.updateEstado();
    }
}
