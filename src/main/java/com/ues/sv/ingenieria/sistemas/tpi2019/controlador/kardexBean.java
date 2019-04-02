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
import java.util.List;
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
public class kardexBean extends AbstractBean<Kardex> implements Serializable{

    @EJB
    KardexFacade facade;
    Kardex entity;
    
    @PostConstruct
    public void init(){
        llenarLista();
        System.out.println("AQUI IGUAL MORRO");
    }
    
    @Override
    protected AbstractFacade<Kardex> getFacade() {
        return facade;
    }

    @Override
    public Kardex getEntity() {
        return entity;
    }

    public List<Kardex> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<Kardex> listaDatos) {
        this.listaDatos = listaDatos;
    }
    
}
