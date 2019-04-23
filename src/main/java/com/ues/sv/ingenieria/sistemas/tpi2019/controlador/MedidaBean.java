/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.MedidaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Medida;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.TipoMedida;
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
public class MedidaBean extends AbstractBean<Medida> implements Serializable{
    
    @EJB
    private MedidaFacade medidaFacade;
    private Medida medida;
    private TipoMedida tipoMedida;
    private boolean botonEdit = false;

    @PostConstruct
    public void init() {
        llenarLista();
        medida = new Medida();
    }

    public void onSelect(Medida select) {
        setBotonEdit(true);
        medida = select;
    }

    public void onDeselect() {
        setBotonEdit(false);
        limpiar();
    }
    
    @Override
    public void crear() {
//        System.out.println(medida.getMedida() + "sda "+ medida.getIdTipoMedida());
        super.crear();
        onDeselect();
    }

    private void limpiar() {
        medida = new Medida();
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
    protected AbstractFacade<Medida> getFacade() {
        return medidaFacade;
    }

    @Override
    public Medida getEntity() {
        return medida;
    }

    public boolean getBotonEdit() {
        return botonEdit;
    }

    public void setBotonEdit(boolean botonEdit) {
        this.botonEdit = botonEdit;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida tipoMedida) {
        this.medida = tipoMedida;
    }

    public TipoMedida getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(TipoMedida tipoMedida) {
        this.tipoMedida = tipoMedida;
    }
    
    
}
