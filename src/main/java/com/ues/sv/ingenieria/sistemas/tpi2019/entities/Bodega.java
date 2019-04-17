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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deadbryam
 */
@Entity
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b")
    , @NamedQuery(name = "Bodega.findByIdArticulo", query = "SELECT b FROM Bodega b WHERE b.bodegaPK.idArticulo = :idArticulo")
    , @NamedQuery(name = "Bodega.findByStock", query = "SELECT b FROM Bodega b WHERE b.stock = :stock")
    , @NamedQuery(name = "Bodega.findByPrecio", query = "SELECT b FROM Bodega b WHERE b.precio = :precio")
    , @NamedQuery(name = "Bodega.findByActivo", query = "SELECT b FROM Bodega b WHERE b.activo = :activo")
    , @NamedQuery(name = "Bodega.findByIdSucursal", query = "SELECT b FROM Bodega b WHERE b.bodegaPK.idSucursal = :idSucursal")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BodegaPK bodegaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sucursal sucursal;

    public Bodega() {
    }

    public Bodega(BodegaPK bodegaPK) {
        this.bodegaPK = bodegaPK;
    }

    public Bodega(BodegaPK bodegaPK, int stock, BigDecimal precio) {
        this.bodegaPK = bodegaPK;
        this.stock = stock;
        this.precio = precio;
    }

    public Bodega(String idArticulo, String idSucursal) {
        this.bodegaPK = new BodegaPK(idArticulo, idSucursal);
    }

    public BodegaPK getBodegaPK() {
        return bodegaPK;
    }

    public void setBodegaPK(BodegaPK bodegaPK) {
        this.bodegaPK = bodegaPK;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bodegaPK != null ? bodegaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.bodegaPK == null && other.bodegaPK != null) || (this.bodegaPK != null && !this.bodegaPK.equals(other.bodegaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.sv.ingenieria.sistemas.tpi2019.entities.Bodega[ bodegaPK=" + bodegaPK + " ]";
    }
    
}
