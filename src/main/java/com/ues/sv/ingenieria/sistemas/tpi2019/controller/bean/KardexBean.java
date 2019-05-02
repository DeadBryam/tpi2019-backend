/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.AbstractFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bryan
 */
@Named(value = "kardexBean")
@ViewScoped
public class KardexBean extends AbstractBean<Kardex> implements Serializable {

    @EJB
    KardexFacade kardexFacade;
    @EJB
    VentaFacade ventaFacade;
    @EJB
    CompraFacade compraFacade;
    private Kardex kardex;
    String tipo;
    String sucursal;
    boolean estado = true;
    boolean btnPedido = false;

    @PostConstruct
    public void init() {
        llenarLista();
    }

    public void onChange() {
        listaDatos = kardexFacade.filtrarKardex(tipo, sucursal, estado);
    }

    public void onSelect(Kardex select) {
        if (!estado) {
            setBtnPedido(true);
            kardex = select;
        }

    }

    public void onDeselect() {
        limpiar();
        setBtnPedido(false);
    }

    public void updateEstado() {
        if (kardex.getIdVenta() != null) {
            kardex.getIdVenta().setEstadoVenta(true);
            ventaFacade.edit(kardex.getIdVenta());
        } else if (kardex.getIdCompra() != null) {
            kardex.getIdCompra().setEstadoCompra(true);
            compraFacade.edit(kardex.getIdCompra());
        }
    }

    public void cancelar() {
        onDeselect();
    }

    // <editor-fold defaultstate="collapsed" desc="Overrrides">
    @Override
    protected AbstractFacade<Kardex> getFacade() {
        return kardexFacade;
    }

    @Override
    public Kardex getEntity() {
        return kardex;
    }

    @Override
    public void crear() {
        super.crear();
        onDeselect();
    }

    private void limpiar() {
        kardex = new Kardex();
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public boolean isBtnPedido() {
        return btnPedido;
    }

    public void setBtnPedido(boolean btnPedido) {
        this.btnPedido = btnPedido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    // </editor-fold>
}
