/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Compra;
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
public class CompraFacadeTest extends AbstractTest<Compra> {

    CompraFacade cf;
    Compra compra, co;

    @Override
    protected AbstractFacade<Compra> getFacade() {
        return new CompraFacade();
    }

    @Override
    protected Compra getEntity() {
        return new Compra(1);
    }

    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        cf = new CompraFacade();
    }

    
    
    @Test
    public void crearTest() {
        co = new Compra(1);
        compra = mock(Compra.class);
        EntityManager em = mock(EntityManager.class);
        Whitebox.setInternalState(cf, "em", em);
        when(cf.crear(compra).getIdCompra()).thenReturn(co.getIdCompra());
        int resultado = cf.crear(compra).getIdCompra();
        assertEquals(1, resultado);
    }

}
