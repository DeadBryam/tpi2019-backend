/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.integration;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author arevalo
 */
public class SucursalIT extends AbstractIT<Sucursal> {

    @Override
    public AbstractFacade<Sucursal> getFacade() {
        return new SucursalFacade();
    }

    @Override
    public Sucursal getEntity() {
        return new Sucursal("1");
    }

    @Override
    public String name() {
        return "Sucursal";
    }

    @Override
    public Object Id() {
        return "1";
    }
    
    @Test
    public void testEdit() {
        System.out.println("edit-IT");

        et.begin();
        cut.create(reg1);
        et.commit();
        em.detach(reg1);

        et.begin();
        cut.edit(reg2);
        et.commit();

       Sucursal resultado = (Sucursal) em.createNamedQuery("Sucursal.findByIdSucursal").setParameter("idSucursal", id).getSingleResult();
        assertEquals(reg2.getIdSucursal(), resultado.getIdSucursal());
        assertEquals(reg2.getUbicacion(), resultado.getUbicacion());
    }
}
