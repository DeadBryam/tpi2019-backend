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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacen.findAll", query = "SELECT a FROM Almacen a")
    , @NamedQuery(name = "Almacen.findByIdArticulo", query = "SELECT a FROM Almacen a WHERE a.idArticulo = :idArticulo")
    , @NamedQuery(name = "Almacen.findByStock", query = "SELECT a FROM Almacen a WHERE a.stock = :stock")
    , @NamedQuery(name = "Almacen.findByPrecio", query = "SELECT a FROM Almacen a WHERE a.precio = :precio")
    , @NamedQuery(name = "Almacen.findByActivo", query = "SELECT a FROM Almacen a WHERE a.activo = :activo")})
public class Almacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_articulo")
    private String idArticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private short stock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "activo")
    private Boolean activo;

    public Almacen() {
    }

    public Almacen(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Almacen(String idArticulo, short stock, BigDecimal precio) {
        this.idArticulo = idArticulo;
        this.stock = stock;
        this.precio = precio;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public short getStock() {
        return stock;
    }

    public void setStock(short stock) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacen)) {
            return false;
        }
        Almacen other = (Almacen) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Almacen[ idArticulo=" + idArticulo + " ]";
    }
    
}
