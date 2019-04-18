/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.controlador;

import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.ArticuloFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.KardexFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.acceso.VentaFacade;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Articulo;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Kardex;
import com.ues.sv.ingenieria.sistemas.tpi2019.entities.Venta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Date;

/**
 *
 * @author deadbryam
 */
@Named
@ViewScoped
public class FacturacionBean implements Serializable {
    
    @EJB
    VentaFacade ventaFacade;
    @EJB
    KardexFacade kardexFacade;
    @EJB
    ArticuloFacade articuloFacade;
    Venta venta;
    Kardex kardex;
    Articulo articulo;
    List<Kardex> facturacionList = new ArrayList<>();
    boolean btnEdit = false;
    Venta idVenta;
    
    @PostConstruct
    public void init() {
        venta = new Venta();
        kardex = new Kardex();
    }
    
    public void crear() {
        venta.setFecha(new Date());
        //ventaFacade.create(venta);
        idVenta = ventaFacade.crear(venta);
        for (Kardex item : facturacionList) {
            item.setIdVenta(idVenta);
            kardexFacade.create(item);
        }
        venta = new Venta();
        facturacionList.clear();
    }
    
    public void add() {
        if ((articulo != null || !articulo.getIdArticulo().isEmpty() || articulo.getIdArticulo() != null) && kardex.getCantidad() > 0) {
            kardex.setIdArticulo(articulo);
            kardex.setPrecioActual(articulo.getPrecio());
            facturacionList.add(kardex);
            kardex = new Kardex();
            onDeselectArticulo();
        }
        System.out.println("FACTURACION"+facturacionList.size());
    }
    
    public void eliminarFacturacion() {
        for (int i = 0; i < facturacionList.size(); i++) {
            if (facturacionList.get(i).getIdArticulo().getIdArticulo().equals(kardex.getIdArticulo().getIdArticulo())
                    && facturacionList.get(i).getCantidad() == kardex.getCantidad()) {
                facturacionList.remove(i);
            }
        }
        kardex = new Kardex();
        setBtnEdit(false);
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
    
    public void cancelar() {
    }

    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public Venta getVenta() {
        return venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public Kardex getKardex() {
        return kardex;
    }
    
    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }
    
    public List<Kardex> getFacturacionList() {
        return facturacionList;
    }
    
    public void setFacturacionList(List<Kardex> facturacionList) {
        this.facturacionList = facturacionList;
    }
    
    public boolean getBtnEdit() {
        return btnEdit;
    }
    
    public void setBtnEdit(boolean btnEdit) {
        this.btnEdit = btnEdit;
    }
//</editor-fold>

}
