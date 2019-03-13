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
@Table(name = "tipo_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMedida.findAll", query = "SELECT t FROM TipoMedida t")
    , @NamedQuery(name = "TipoMedida.findByIdTipoMedida", query = "SELECT t FROM TipoMedida t WHERE t.idTipoMedida = :idTipoMedida")
    , @NamedQuery(name = "TipoMedida.findByTipoMedida", query = "SELECT t FROM TipoMedida t WHERE t.tipoMedida = :tipoMedida")})
public class TipoMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_medida")
    private Short idTipoMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_medida")
    private String tipoMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMedida")
    private List<Medida> medidaList;

    public TipoMedida() {
    }

    public TipoMedida(Short idTipoMedida) {
        this.idTipoMedida = idTipoMedida;
    }

    public TipoMedida(Short idTipoMedida, String tipoMedida) {
        this.idTipoMedida = idTipoMedida;
        this.tipoMedida = tipoMedida;
    }

    public Short getIdTipoMedida() {
        return idTipoMedida;
    }

    public void setIdTipoMedida(Short idTipoMedida) {
        this.idTipoMedida = idTipoMedida;
    }

    public String getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(String tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    @XmlTransient
    public List<Medida> getMedidaList() {
        return medidaList;
    }

    public void setMedidaList(List<Medida> medidaList) {
        this.medidaList = medidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMedida != null ? idTipoMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMedida)) {
            return false;
        }
        TipoMedida other = (TipoMedida) object;
        if ((this.idTipoMedida == null && other.idTipoMedida != null) || (this.idTipoMedida != null && !this.idTipoMedida.equals(other.idTipoMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoMedida[ idTipoMedida=" + idTipoMedida + " ]";
    }
    
}
