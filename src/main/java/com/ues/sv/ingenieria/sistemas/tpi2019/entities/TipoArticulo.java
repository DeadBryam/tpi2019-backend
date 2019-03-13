/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.entities;

import java.io.Serializable;
import java.util.List;
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
 * @author bryan
 */
@Entity
@Table(name = "tipo_articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoArticulo.findAll", query = "SELECT t FROM TipoArticulo t")
    , @NamedQuery(name = "TipoArticulo.findByIdTipoArticulo", query = "SELECT t FROM TipoArticulo t WHERE t.idTipoArticulo = :idTipoArticulo")
    , @NamedQuery(name = "TipoArticulo.findByTipoArticulo", query = "SELECT t FROM TipoArticulo t WHERE t.tipoArticulo = :tipoArticulo")})
public class TipoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_articulo")
    private Short idTipoArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_articulo")
    private String tipoArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoArticulo")
    private List<Articulo> articuloList;

    public TipoArticulo() {
    }

    public TipoArticulo(Short idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public TipoArticulo(Short idTipoArticulo, String tipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
        this.tipoArticulo = tipoArticulo;
    }

    public Short getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(Short idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    @XmlTransient
    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoArticulo != null ? idTipoArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoArticulo)) {
            return false;
        }
        TipoArticulo other = (TipoArticulo) object;
        if ((this.idTipoArticulo == null && other.idTipoArticulo != null) || (this.idTipoArticulo != null && !this.idTipoArticulo.equals(other.idTipoArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoArticulo[ idTipoArticulo=" + idTipoArticulo + " ]";
    }
    
}
