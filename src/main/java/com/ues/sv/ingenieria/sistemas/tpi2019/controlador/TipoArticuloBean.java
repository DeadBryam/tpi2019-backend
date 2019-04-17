/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.TipoArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.TipoArticulo;
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
public class TipoArticuloBean extends AbstractBean<TipoArticulo> implements Serializable {

    @EJB
    private TipoArticuloFacade tipoArticuloFacade;
    private TipoArticulo tipoArticulo;
    private boolean botonEdit = false;

    @PostConstruct
    public void init() {
        llenarLista();
        tipoArticulo = new TipoArticulo();
    }

    public void onSelect(TipoArticulo select) {
        setBotonEdit(true);
        tipoArticulo = select;

    }

    public void onDeselect() {
        setBotonEdit(false);
        limpiar();
    }

    @Override
    public void crear() {
        super.crear();
        onDeselect();
    }

    private void limpiar() {
        tipoArticulo = new TipoArticulo();
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

    public void cancelar() {
        onDeselect();
    }

    @Override
    protected AbstractFacade<TipoArticulo> getFacade() {
        return tipoArticuloFacade;
    }

    @Override
    public TipoArticulo getEntity() {
        return tipoArticulo;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

}
