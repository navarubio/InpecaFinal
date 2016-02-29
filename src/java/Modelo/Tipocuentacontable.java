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
@Table(name = "tipocuentacontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocuentacontable.findAll", query = "SELECT t FROM Tipocuentacontable t"),
    @NamedQuery(name = "Tipocuentacontable.findByIdtipocuentacontable", query = "SELECT t FROM Tipocuentacontable t WHERE t.idtipocuentacontable = :idtipocuentacontable"),
    @NamedQuery(name = "Tipocuentacontable.findByTipocuentacontable", query = "SELECT t FROM Tipocuentacontable t WHERE t.tipocuentacontable = :tipocuentacontable")})
public class Tipocuentacontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipocuentacontable")
    private Integer idtipocuentacontable;
    @Size(max = 100)
    @Column(name = "tipocuentacontable")
    private String tipocuentacontable;
    @OneToMany(mappedBy = "idtipocuentacontable")
    private Collection<Plandecuenta> plandecuentaCollection;

    public Tipocuentacontable() {
    }

    public Tipocuentacontable(Integer idtipocuentacontable) {
        this.idtipocuentacontable = idtipocuentacontable;
    }

    public Integer getIdtipocuentacontable() {
        return idtipocuentacontable;
    }

    public void setIdtipocuentacontable(Integer idtipocuentacontable) {
        this.idtipocuentacontable = idtipocuentacontable;
    }

    public String getTipocuentacontable() {
        return tipocuentacontable;
    }

    public void setTipocuentacontable(String tipocuentacontable) {
        this.tipocuentacontable = tipocuentacontable;
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
        hash += (idtipocuentacontable != null ? idtipocuentacontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocuentacontable)) {
            return false;
        }
        Tipocuentacontable other = (Tipocuentacontable) object;
        if ((this.idtipocuentacontable == null && other.idtipocuentacontable != null) || (this.idtipocuentacontable != null && !this.idtipocuentacontable.equals(other.idtipocuentacontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipocuentacontable;
    }
    
}
