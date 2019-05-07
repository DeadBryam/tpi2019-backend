/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.SucursalFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
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
public class SucursalBean extends AbstractBean<Sucursal> implements Serializable {

    @EJB
    SucursalFacade sucursalFacade;
    Sucursal sucursal;
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

    public void onSelect(Sucursal select) {
        setBotonEdit(true);
        sucursal = select;
    }

    public void onDeselect() {
        setBotonEdit(false);
        limpiar();
    }

    public void cancelar() {
        onDeselect();
    }

    private void limpiar() {
        sucursal = new Sucursal();
    }

    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
