/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Kardex;
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
public class kardexBean extends AbstractBean<Kardex> implements Serializable {

    @EJB
    private KardexFacade kardexFacade;
    private Kardex kardex;
    private boolean botonEdit = false;

    @PostConstruct
    public void init() {
        llenarLista();
    }

    public void onSelect(Kardex select) {
        setBotonEdit(true);
        kardex = select;
    }

    public void onDeselect() {
        setBotonEdit(false);
        limpiar();
    }

    public void cancelar() {
        onDeselect();
    }

    // <editor-fold defaultstate="collapsed" desc="Overrrides">
    @Override
    protected AbstractFacade<Kardex> getFacade() {
        return kardexFacade;
    }

    @Override
    public Kardex getEntity() {
        return kardex;
    }

    @Override
    public void crear() {
        super.crear();
        onDeselect();
    }

    private void limpiar() {
        kardex = new Kardex();
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }
    // </editor-fold>
}
