/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Caja;
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
public class CajaBean extends AbstractBean<Caja> implements Serializable {

    @EJB
    CajaFacade cajaFacade;
    Caja caja;
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

    public void onSelect(Caja select) {
        setBotonEdit(true);
        caja = select;
    }

    public void onDeselect() {
        setBotonEdit(false);
        limpiar();
    }

    public void cancelar() {
        onDeselect();
    }

    private void limpiar() {
        caja = new Caja();
    }

    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

    @Override
    protected AbstractFacade<Caja> getFacade() {
        return cajaFacade;
    }

    @Override
    public Caja getEntity() {
        return caja;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }
}
