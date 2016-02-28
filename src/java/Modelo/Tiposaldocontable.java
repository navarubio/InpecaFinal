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
@Table(name = "tiposaldocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposaldocontable.findAll", query = "SELECT t FROM Tiposaldocontable t"),
    @NamedQuery(name = "Tiposaldocontable.findByIdtiposaldocontable", query = "SELECT t FROM Tiposaldocontable t WHERE t.idtiposaldocontable = :idtiposaldocontable"),
    @NamedQuery(name = "Tiposaldocontable.findByTiposaldocontable", query = "SELECT t FROM Tiposaldocontable t WHERE t.tiposaldocontable = :tiposaldocontable")})
public class Tiposaldocontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtiposaldocontable")
    private Integer idtiposaldocontable;
    @Size(max = 100)
    @Column(name = "tiposaldocontable")
    private String tiposaldocontable;
    @OneToMany(mappedBy = "idtiposaldocontable")
    private Collection<Plandecuenta> plandecuentaCollection;

    public Tiposaldocontable() {
    }

    public Tiposaldocontable(Integer idtiposaldocontable) {
        this.idtiposaldocontable = idtiposaldocontable;
    }

    public Integer getIdtiposaldocontable() {
        return idtiposaldocontable;
    }

    public void setIdtiposaldocontable(Integer idtiposaldocontable) {
        this.idtiposaldocontable = idtiposaldocontable;
    }

    public String getTiposaldocontable() {
        return tiposaldocontable;
    }

    public void setTiposaldocontable(String tiposaldocontable) {
        this.tiposaldocontable = tiposaldocontable;
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
        hash += (idtiposaldocontable != null ? idtiposaldocontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposaldocontable)) {
            return false;
        }
        Tiposaldocontable other = (Tiposaldocontable) object;
        if ((this.idtiposaldocontable == null && other.idtiposaldocontable != null) || (this.idtiposaldocontable != null && !this.idtiposaldocontable.equals(other.idtiposaldocontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tiposaldocontable[ idtiposaldocontable=" + idtiposaldocontable + " ]";
    }
    
}
