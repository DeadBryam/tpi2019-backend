/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;
import java.math.BigDecimal;
import java.util.Collections;
import javax.management.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class ArticuloBeanTest  extends AbstractBeanTest<Articulo>{

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
    
    
    
}
