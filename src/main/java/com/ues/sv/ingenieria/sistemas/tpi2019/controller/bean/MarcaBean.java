/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.MarcaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Marca;
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
public class MarcaBean extends AbstractBean<Marca> implements Serializable {

    @EJB
    private MarcaFacade marcaFacade;
    private Marca marca;
    private boolean botonEdit = false;

    @PostConstruct
    public void init() {
        llenarLista();
        marca = new Marca();
    }

    public void onSelect(Marca select) {
        setBotonEdit(true);
        marca = select;
        
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
    
    private void limpiar(){
        marca = new Marca();
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
    
    public void cancelar(){
        onDeselect();
    }

    @Override
    protected AbstractFacade<Marca> getFacade() {
        return marcaFacade;
    }

    @Override
    public Marca getEntity() {
        return marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }
    
}
