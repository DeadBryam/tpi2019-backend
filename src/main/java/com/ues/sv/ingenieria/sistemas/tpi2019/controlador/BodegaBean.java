/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.BodegaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Bodega;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Sucursal;
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
    private Articulo articulo;
    private final Bodega instance = new Bodega();

    @PostConstruct
    public void init() {
        llenarLista();
        System.out.println("BODEGA");
    }
    
    public void almacen(){
        
    }

    public Articulo getArticulo(String id) {
        return articuloFacade.findById(id);
    }

    @Override
    protected AbstractFacade<Bodega> getFacade() {
        return bodegaFacade;
    }

    @Override
    public Bodega getEntity() {
        return bodega;
    }
}
