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
 * @author bryan
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
    private Short idMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "medida")
    private String medida;
    @JoinColumn(name = "id_tipo_medida", referencedColumnName = "id_tipo_medida")
    @ManyToOne(optional = false)
    private TipoMedida idTipoMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedida")
    private List<Articulo> articuloList;

    public Medida() {
    }

    public Medida(Short idMedida) {
        this.idMedida = idMedida;
    }

    public Medida(Short idMedida, String medida) {
        this.idMedida = idMedida;
        this.medida = medida;
    }

    public Short getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Short idMedida) {
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
    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
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
        return "entities.Medida[ idMedida=" + idMedida + " ]";
    }
    
}
