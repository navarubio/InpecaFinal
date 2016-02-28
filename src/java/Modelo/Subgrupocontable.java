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
@Table(name = "subgrupocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subgrupocontable.findAll", query = "SELECT s FROM Subgrupocontable s"),
    @NamedQuery(name = "Subgrupocontable.findByIdsubgrupocontable", query = "SELECT s FROM Subgrupocontable s WHERE s.idsubgrupocontable = :idsubgrupocontable"),
    @NamedQuery(name = "Subgrupocontable.findBySubgrupocontable", query = "SELECT s FROM Subgrupocontable s WHERE s.subgrupocontable = :subgrupocontable")})
public class Subgrupocontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsubgrupocontable")
    private Integer idsubgrupocontable;
    @Size(max = 100)
    @Column(name = "subgrupocontable")
    private String subgrupocontable;
    @OneToMany(mappedBy = "idsubgrupocontable")
    private Collection<Especificocontable> especificocontableCollection;
    @OneToMany(mappedBy = "idsubgrupocontable")
    private Collection<Plandecuenta> plandecuentaCollection;
    @OneToMany(mappedBy = "idsubgrupocontable")
    private Collection<Subespecificocontable> subespecificocontableCollection;
    @JoinColumn(name = "idgrupocontable", referencedColumnName = "idgrupocontable")
    @ManyToOne
    private Grupocontable idgrupocontable;

    public Subgrupocontable() {
    }

    public Subgrupocontable(Integer idsubgrupocontable) {
        this.idsubgrupocontable = idsubgrupocontable;
    }

    public Integer getIdsubgrupocontable() {
        return idsubgrupocontable;
    }

    public void setIdsubgrupocontable(Integer idsubgrupocontable) {
        this.idsubgrupocontable = idsubgrupocontable;
    }

    public String getSubgrupocontable() {
        return subgrupocontable;
    }

    public void setSubgrupocontable(String subgrupocontable) {
        this.subgrupocontable = subgrupocontable;
    }

    @XmlTransient
    public Collection<Especificocontable> getEspecificocontableCollection() {
        return especificocontableCollection;
    }

    public void setEspecificocontableCollection(Collection<Especificocontable> especificocontableCollection) {
        this.especificocontableCollection = especificocontableCollection;
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

    public Grupocontable getIdgrupocontable() {
        return idgrupocontable;
    }

    public void setIdgrupocontable(Grupocontable idgrupocontable) {
        this.idgrupocontable = idgrupocontable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubgrupocontable != null ? idsubgrupocontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupocontable)) {
            return false;
        }
        Subgrupocontable other = (Subgrupocontable) object;
        if ((this.idsubgrupocontable == null && other.idsubgrupocontable != null) || (this.idsubgrupocontable != null && !this.idsubgrupocontable.equals(other.idsubgrupocontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return subgrupocontable;
    }
    
}
