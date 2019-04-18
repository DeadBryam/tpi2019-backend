/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Distribuidor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bryan
 */
@Named
@ViewScoped
public class DistribuidorBean extends AbstractBean<Distribuidor> implements Serializable {

    @EJB
    private DistribuidorFacade facade;
    private Distribuidor distribuidor;

    @PostConstruct
    public void init() {
        llenarLista();
    }

    public void setFacade(DistribuidorFacade facade) {
        this.facade = facade;
    }

    public void setEntity(Distribuidor entity) {
        this.distribuidor = entity;
    }

    @Override
    public DistribuidorFacade getFacade() {
        return facade;
    }

    @Override
    public Distribuidor getEntity() {
        return distribuidor;
    }


}
