/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.CajaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Caja;
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
public class CajaBean extends AbstractBean<Caja> implements Serializable{
    
    @EJB
    CajaFacade cajaFacade;
    Caja caja;
    
    @PostConstruct
    public void init(){
        llenarLista();
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
