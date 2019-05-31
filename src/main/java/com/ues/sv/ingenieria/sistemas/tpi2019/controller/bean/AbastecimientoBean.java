/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controller.bean;

import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.CompraFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.access.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Compra;
import com.ues.sv.ingenieria.sistemas.tpi2019.model.data.Kardex;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class AbastecimientoBean implements Serializable {

    @EJB
    CompraFacade compraFacade;
    @EJB
    KardexFacade kardexFacade;
    @EJB
    ArticuloFacade articuloFacade;
    Compra compra;
    Kardex kardex;
    Articulo articulo;
    List<Kardex> abastecimientoList = new ArrayList<>();
    boolean btnEdit = false;
    Compra idCompra;

    @PostConstruct
    public void init() {
        compra = new Compra();
        kardex = new Kardex();
    }

    public String articuloCompleto(String id) {
        if (id.isEmpty() || id == null) {
            return "";
        }
        return articuloFacade.getArticuloCompleto(id);
    }

    public void crear() {
        compra.setFecha(new Date());
        //compraFacade.create(compra);
        //idCompra = compraFacade.getIdCompra(compra);
        idCompra = compraFacade.crear(compra);
        System.out.println("SIRVE "+idCompra.getIdCompra());
        for (Kardex item : abastecimientoList) {
            item.setIdCompra(idCompra);
            kardexFacade.create(item);
        }
        compra = new Compra();
        abastecimientoList.clear();
    }

    public void add() {
        if ((articulo != null || !articulo.getIdArticulo().isEmpty() || articulo.getIdArticulo() != null) && kardex.getCantidad() > 0) {
            kardex.setIdArticulo(articulo);
            kardex.setPrecioAnterior(articulo.getPrecio());
            abastecimientoList.add(kardex);
            kardex = new Kardex();
            onDeselectArticulo();
        }
        System.out.println("ABASTECIMIENTO"+abastecimientoList.size());
    }

    public void onSelectArticulo(Articulo select) {
        articulo = select;
    }

    public void onDeselectArticulo() {
        articulo = new Articulo();
    }

    public void onSelectKardex(Kardex select) {
        kardex = select;
        setBtnEdit(true);
    }

    public void onDeselectKardex() {
        kardex = new Kardex();
        setBtnEdit(false);
    }

    public void eliminarFacturacion() {
        for (int i = 0; i < abastecimientoList.size(); i++) {
            if (abastecimientoList.get(i).getIdArticulo().getIdArticulo().equals(kardex.getIdArticulo().getIdArticulo())
                    && abastecimientoList.get(i).getCantidad() == kardex.getCantidad()) {
                abastecimientoList.remove(i);
            }
        }
        kardex = new Kardex();
        setBtnEdit(false);
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public List<Kardex> getAbastecimientoList() {
        return abastecimientoList;
    }

    public void setAbastecimientoList(List<Kardex> abastecimientoList) {
        this.abastecimientoList = abastecimientoList;
    }

    public boolean getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(boolean btnEdit) {
        this.btnEdit = btnEdit;
    }
    //</editor-fold>
}
