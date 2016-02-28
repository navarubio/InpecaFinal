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
 * @author Inpeca
 */
@Entity
@Table(name = "especificocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especificocontable.findAll", query = "SELECT e FROM Especificocontable e"),
    @NamedQuery(name = "Especificocontable.findByIdespecificocontable", query = "SELECT e FROM Especificocontable e WHERE e.idespecificocontable = :idespecificocontable"),
    @NamedQuery(name = "Especificocontable.findByEspecificocontable", query = "SELECT e FROM Especificocontable e WHERE e.especificocontable = :especificocontable")})
public class Especificocontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idespecificocontable")
    private Integer idespecificocontable;
    @Size(max = 100)
    @Column(name = "especificocontable")
    private String especificocontable;
    @JoinColumn(name = "idgrupocontable", referencedColumnName = "idgrupocontable")
    @ManyToOne
    private Grupocontable idgrupocontable;
    @JoinColumn(name = "idsubgrupocontable", referencedColumnName = "idsubgrupocontable")
    @ManyToOne
    private Subgrupocontable idsubgrupocontable;
    @OneToMany(mappedBy = "idespecificocontable")
    private Collection<Plandecuenta> plandecuentaCollection;
    @OneToMany(mappedBy = "idespecificocontable")
    private Collection<Subespecificocontable> subespecificocontableCollection;

    public Especificocontable() {
    }

    public Especificocontable(Integer idespecificocontable) {
        this.idespecificocontable = idespecificocontable;
    }

    public Integer getIdespecificocontable() {
        return idespecificocontable;
    }

    public void setIdespecificocontable(Integer idespecificocontable) {
        this.idespecificocontable = idespecificocontable;
    }

    public String getEspecificocontable() {
        return especificocontable;
    }

    public void setEspecificocontable(String especificocontable) {
        this.especificocontable = especificocontable;
    }

    public Grupocontable getIdgrupocontable() {
        return idgrupocontable;
    }

    public void setIdgrupocontable(Grupocontable idgrupocontable) {
        this.idgrupocontable = idgrupocontable;
    }

    public Subgrupocontable getIdsubgrupocontable() {
        return idsubgrupocontable;
    }

    public void setIdsubgrupocontable(Subgrupocontable idsubgrupocontable) {
        this.idsubgrupocontable = idsubgrupocontable;
    }

    @XmlTransient
    public Collection<Plandecuenta> getPlandecuentaCollection() {
        return plandecuentaCollection;
    }

    public void setPlandecuentaCollection(Collection<Plandecuenta> plandecuentaCollection) {
        this.plandecuentaCollection = plandecuentaCollection;
    }

    @XmlTransient
    public Collection<Subespecificocontable> getSubespecificocontableCollection() {
        return subespecificocontableCollection;
    }

    public void setSubespecificocontableCollection(Collection<Subespecificocontable> subespecificocontableCollection) {
        this.subespecificocontableCollection = subespecificocontableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecificocontable != null ? idespecificocontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especificocontable)) {
            return false;
        }
        Especificocontable other = (Especificocontable) object;
        if ((this.idespecificocontable == null && other.idespecificocontable != null) || (this.idespecificocontable != null && !this.idespecificocontable.equals(other.idespecificocontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return especificocontable;
    }
    
}
