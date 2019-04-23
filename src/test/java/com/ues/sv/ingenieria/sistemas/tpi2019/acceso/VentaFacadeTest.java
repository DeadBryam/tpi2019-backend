/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.acceso;

import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Venta;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author arevalo
 */
public class VentaFacadeTest extends AbstractTest<Venta> {

    Venta venta, ve;
    VentaFacade vf;

    @Override
    protected AbstractFacade<Venta> getFacade() {
        return new VentaFacade();
    }

    @Override
    protected Venta getEntity() {
        return new Venta(1);
    }

    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        vf = new VentaFacade();
    }
    
    

    @Test
    public void crearTest() {
        ve = new Venta(1);
        venta = mock(Venta.class);
        EntityManager em = mock(EntityManager.class);
        Whitebox.setInternalState(vf, "em", em);
        when(vf.crear(venta).getIdVenta()).thenReturn(ve.getIdVenta());
        int resultado = vf.crear(venta).getIdVenta();
        assertEquals(1, resultado);
    }
}
