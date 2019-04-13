/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author deadbryam
 */
@Entity
@Table(name = "num_bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumBodega.findAll", query = "SELECT n FROM NumBodega n")
    , @NamedQuery(name = "NumBodega.findByIdNumBodega", query = "SELECT n FROM NumBodega n WHERE n.idNumBodega = :idNumBodega")
    , @NamedQuery(name = "NumBodega.findByUbicacion", query = "SELECT n FROM NumBodega n WHERE n.ubicacion = :ubicacion")
    , @NamedQuery(name = "NumBodega.findByActivo", query = "SELECT n FROM NumBodega n WHERE n.activo = :activo")})
public class NumBodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_num_bodega")
    private Integer idNumBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNumBodega")
    private Collection<Bodega> bodegaCollection;

    public NumBodega() {
    }

    public NumBodega(Integer idNumBodega) {
        this.idNumBodega = idNumBodega;
    }

    public NumBodega(Integer idNumBodega, String ubicacion, boolean activo) {
        this.idNumBodega = idNumBodega;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }

    public Integer getIdNumBodega() {
        return idNumBodega;
    }

    public void setIdNumBodega(Integer idNumBodega) {
        this.idNumBodega = idNumBodega;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Bodega> getBodegaCollection() {
        return bodegaCollection;
    }

    public void setBodegaCollection(Collection<Bodega> bodegaCollection) {
        this.bodegaCollection = bodegaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumBodega != null ? idNumBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumBodega)) {
            return false;
        }
        NumBodega other = (NumBodega) object;
        if ((this.idNumBodega == null && other.idNumBodega != null) || (this.idNumBodega != null && !this.idNumBodega.equals(other.idNumBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.sv.ingenieria.sistemas.tpi2019.datos.NumBodega[ idNumBodega=" + idNumBodega + " ]";
    }
    
}
