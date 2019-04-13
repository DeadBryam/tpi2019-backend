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
import javax.validation.constraints.Size;
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
    , @NamedQuery(name = "Bodega.findByIdArticulo", query = "SELECT b FROM Bodega b WHERE b.idArticulo = :idArticulo")
    , @NamedQuery(name = "Bodega.findByStock", query = "SELECT b FROM Bodega b WHERE b.stock = :stock")
    , @NamedQuery(name = "Bodega.findByPrecio", query = "SELECT b FROM Bodega b WHERE b.precio = :precio")
    , @NamedQuery(name = "Bodega.findByActivo", query = "SELECT b FROM Bodega b WHERE b.activo = :activo")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "id_articulo")
    private String idArticulo;
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
    @JoinColumn(name = "id_num_bodega", referencedColumnName = "id_num_bodega")
    @ManyToOne(optional = false)
    private NumBodega idNumBodega;

    public Bodega() {
    }

    public Bodega(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Bodega(String idArticulo, int stock, BigDecimal precio) {
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

    public NumBodega getIdNumBodega() {
        return idNumBodega;
    }

    public void setIdNumBodega(NumBodega idNumBodega) {
        this.idNumBodega = idNumBodega;
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
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.sv.ingenieria.sistemas.tpi2019.datos.Bodega[ idArticulo=" + idArticulo + " ]";
    }
    
}
