/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class ArticuloBean extends AbstractBean<Articulo> implements Serializable {

    @EJB
    private ArticuloFacade articuloFacade;
    private Articulo articulo;
    private boolean botonEdit = false;

    @PostConstruct
    public void init() {
        llenarLista();
        articulo = new Articulo();
    }
    
    public String articuloCompleto(String id) {
        if (id.isEmpty() || id == null) {
            return "";
        }
        return articuloFacade.getArticuloCompleto(id);
    }

    public void onSelect(Articulo select) {
        setBotonEdit(true);
        articulo = select;
    }

    public void onDeselect() {
        setBotonEdit(false);
        limpiar();
    }

    @Override
    public void crear() {
    //    articulo.setPrecio(BigDecimal.ZERO);
        super.crear();
        onDeselect();
    }

    private void limpiar() {
        articulo = new Articulo();
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
    protected AbstractFacade<Articulo> getFacade() {
        return articuloFacade;
    }

    @Override
    public Articulo getEntity() {
        return articulo;
    }

    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
