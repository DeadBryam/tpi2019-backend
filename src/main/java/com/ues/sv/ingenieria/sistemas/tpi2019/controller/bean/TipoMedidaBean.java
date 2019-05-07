/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.TipoMedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.TipoMedida;
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
public class TipoMedidaBean extends AbstractBean<TipoMedida> implements Serializable {

    @EJB
    private TipoMedidaFacade tipoMedidaFacade;
    private TipoMedida tipoMedida;
    private boolean botonEdit = false;

    @PostConstruct
    public void init() {
        llenarLista();
        tipoMedida = new TipoMedida();
        System.out.println("TipoMedidaBean");
    }

    public void onSelect(TipoMedida select) {
        setBotonEdit(true);
        tipoMedida = select;
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
        tipoMedida = new TipoMedida();
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
    protected AbstractFacade<TipoMedida> getFacade() {
        return tipoMedidaFacade;
    }

    @Override
    public TipoMedida getEntity() {
        return tipoMedida;
    }

    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

    public TipoMedida getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(TipoMedida tipoMedida) {
        this.tipoMedida = tipoMedida;
    }
}
