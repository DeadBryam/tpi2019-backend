/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Sucursal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author deadbryam
 */
@Named
@ViewScoped
public class sucursalBean extends AbstractBean<Sucursal> implements Serializable{
    
    @EJB
    SucursalFacade sucursalFacade;
    Sucursal sucursal;

        @PostConstruct
    public void init() {
        llenarLista();
    }
    
    @Override
    protected AbstractFacade<Sucursal> getFacade() {
        return sucursalFacade;
    }

    @Override
    public Sucursal getEntity() {
        return sucursal;
    }
    
}
