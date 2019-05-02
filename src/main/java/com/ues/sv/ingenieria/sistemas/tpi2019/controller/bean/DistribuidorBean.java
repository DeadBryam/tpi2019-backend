/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.DistribuidorFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Distribuidor;
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
    private boolean botonEdit = false;

    @PostConstruct
    public void init() {
        llenarLista();
        limpiar();
    }

    @Override
    public void crear() {
        super.crear();
        onDeselect();
    }

    @Override
    public void editar() {
        super.editar();
        onDeselect();
    }

    @Override
    public void eliminar() {
        super.eliminar();
        onDeselect();
    }

    public void onSelect(Distribuidor select) {
        setBotonEdit(true);
        distribuidor = select;
    }

    public void onDeselect() {
        setBotonEdit(false);
        limpiar();
    }

    public void cancelar() {
        onDeselect();
    }

    private void limpiar() {
        distribuidor = new Distribuidor();
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

    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }
}
