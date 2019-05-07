/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Bodega;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Sucursal;
import java.io.Serializable;
import java.util.List;
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
public class BodegaBean extends AbstractBean<Bodega> implements Serializable {

    @EJB
    private BodegaFacade bodegaFacade;
    @EJB
    private ArticuloFacade articuloFacade;
    private Bodega bodega;
    private Sucursal sucursal;

    @PostConstruct
    public void init() {
        llenarLista();
        System.out.println("BODEGA");
    }

    @Override
    protected AbstractFacade<Bodega> getFacade() {
        return bodegaFacade;
    }

    @Override
    public Bodega getEntity() {
        return bodega;
    }

    public void onChange() {
        System.out.println("HOLA");
        if (sucursal != null) {
            listaDatos = bodegaFacade.bodegaPorSucursal(sucursal.getIdSucursal());
        }else{
            llenarLista();
        }
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

}
