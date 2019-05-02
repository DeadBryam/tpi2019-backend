/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.KardexBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean.AbstractBean;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;

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
        return new KardexBean();
    }
    
}
