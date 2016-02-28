/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "tipopartidacontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopartidacontable.findAll", query = "SELECT t FROM Tipopartidacontable t"),
    @NamedQuery(name = "Tipopartidacontable.findByIdtipopartidacontable", query = "SELECT t FROM Tipopartidacontable t WHERE t.idtipopartidacontable = :idtipopartidacontable"),
    @NamedQuery(name = "Tipopartidacontable.findByTipopartidacontable", query = "SELECT t FROM Tipopartidacontable t WHERE t.tipopartidacontable = :tipopartidacontable")})
public class Tipopartidacontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipopartidacontable")
    private Integer idtipopartidacontable;
    @Size(max = 100)
    @Column(name = "tipopartidacontable")
    private String tipopartidacontable;
    @OneToMany(mappedBy = "idtipopartidacontable")
    private Collection<Plandecuenta> plandecuentaCollection;

    public Tipopartidacontable() {
    }

    public Tipopartidacontable(Integer idtipopartidacontable) {
        this.idtipopartidacontable = idtipopartidacontable;
    }

    public Integer getIdtipopartidacontable() {
        return idtipopartidacontable;
    }

    public void setIdtipopartidacontable(Integer idtipopartidacontable) {
        this.idtipopartidacontable = idtipopartidacontable;
    }

    public String getTipopartidacontable() {
        return tipopartidacontable;
    }

    public void setTipopartidacontable(String tipopartidacontable) {
        this.tipopartidacontable = tipopartidacontable;
    }

    @XmlTransient
    public Collection<Plandecuenta> getPlandecuentaCollection() {
        return plandecuentaCollection;
    }

    public void setPlandecuentaCollection(Collection<Plandecuenta> plandecuentaCollection) {
        this.plandecuentaCollection = plandecuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipopartidacontable != null ? idtipopartidacontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopartidacontable)) {
            return false;
        }
        Tipopartidacontable other = (Tipopartidacontable) object;
        if ((this.idtipopartidacontable == null && other.idtipopartidacontable != null) || (this.idtipopartidacontable != null && !this.idtipopartidacontable.equals(other.idtipopartidacontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tipopartidacontable[ idtipopartidacontable=" + idtipopartidacontable + " ]";
    }
    
}
