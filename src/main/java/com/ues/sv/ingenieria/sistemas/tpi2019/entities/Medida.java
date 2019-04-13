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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medida.findAll", query = "SELECT m FROM Medida m")
    , @NamedQuery(name = "Medida.findByIdMedida", query = "SELECT m FROM Medida m WHERE m.idMedida = :idMedida")
    , @NamedQuery(name = "Medida.findByMedida", query = "SELECT m FROM Medida m WHERE m.medida = :medida")})
public class Medida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medida")
    private Integer idMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "medida")
    private String medida;
    @JoinColumn(name = "id_tipo_medida", referencedColumnName = "id_tipo_medida")
    @ManyToOne(optional = false)
    private TipoMedida idTipoMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedida")
    private Collection<Articulo> articuloCollection;

    public Medida() {
    }

    public Medida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public Medida(Integer idMedida, String medida) {
        this.idMedida = idMedida;
        this.medida = medida;
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public TipoMedida getIdTipoMedida() {
        return idTipoMedida;
    }

    public void setIdTipoMedida(TipoMedida idTipoMedida) {
        this.idTipoMedida = idTipoMedida;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedida != null ? idMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medida)) {
            return false;
        }
        Medida other = (Medida) object;
        if ((this.idMedida == null && other.idMedida != null) || (this.idMedida != null && !this.idMedida.equals(other.idMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.sv.ingenieria.sistemas.tpi2019.datos.Medida[ idMedida=" + idMedida + " ]";
    }
    
}
