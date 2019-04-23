/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author arevalo
 */
public class ArticuloBeanTest extends AbstractBeanTest<Articulo> {

    ArticuloBean bean = new ArticuloBean();
    String id = "200IQ";

    @Override
    protected AbstractFacade<Articulo> getFacade() {
        return new ArticuloFacade();
    }

    @Override
    public Articulo getEntity() {
        return new Articulo();
    }

    @Override
    protected AbstractBean<Articulo> getBean() {
        return new ArticuloBean();
    }

    @Override
    public void init() {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    public void onSelectTest() {
        bean.onSelect(new Articulo(id));
        Assert.assertTrue(bean.getBotonEdit());
    }

    @Test
    public void articuloCompletoTest() {
        String resultado;
        resultado = bean.articuloCompleto("");
        Assert.assertEquals("", resultado);

    }

}
