/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Kardex;

/**
 *
 * @author arevalo
 */
public class KardexBeanTest extends AbstractBeanTest<Kardex>{

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
        return new kardexBean();
    }
    
}
