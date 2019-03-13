/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "kardex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kardex.findAll", query = "SELECT k FROM Kardex k")
    , @NamedQuery(name = "Kardex.findByIdKardex", query = "SELECT k FROM Kardex k WHERE k.idKardex = :idKardex")
    , @NamedQuery(name = "Kardex.findByCantidad", query = "SELECT k FROM Kardex k WHERE k.cantidad = :cantidad")
    , @NamedQuery(name = "Kardex.findByPrecioCompra", query = "SELECT k FROM Kardex k WHERE k.precioCompra = :precioCompra")
    , @NamedQuery(name = "Kardex.findByPrecioVenta", query = "SELECT k FROM Kardex k WHERE k.precioVenta = :precioVenta")})
public class Kardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_kardex")
    private Short idKardex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private short cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_compra")
    private BigDecimal precioCompra;
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private Articulo idArticulo;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    @ManyToOne
    private Compra idCompra;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne
    private Venta idVenta;

    public Kardex() {
    }

    public Kardex(Short idKardex) {
        this.idKardex = idKardex;
    }

    public Kardex(Short idKardex, short cantidad) {
        this.idKardex = idKardex;
        this.cantidad = cantidad;
    }

    public Short getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(Short idKardex) {
        this.idKardex = idKardex;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKardex != null ? idKardex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if ((this.idKardex == null && other.idKardex != null) || (this.idKardex != null && !this.idKardex.equals(other.idKardex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Kardex[ idKardex=" + idKardex + " ]";
    }
    
}
