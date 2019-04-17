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
    private KardexFacade facade;
    private Kardex entidad;
    private final Kardex instace = new Kardex();

    @PostConstruct
    public void init() {
        llenarLista();
    }

    @Override
    protected AbstractFacade<Kardex> getFacade() {
        return facade;
    }

    @Override
    public Kardex getEntity() {
        return entidad;
    }

}
