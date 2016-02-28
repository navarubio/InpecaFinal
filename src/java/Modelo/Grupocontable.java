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
@Table(name = "grupocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupocontable.findAll", query = "SELECT g FROM Grupocontable g"),
    @NamedQuery(name = "Grupocontable.findByIdgrupocontable", query = "SELECT g FROM Grupocontable g WHERE g.idgrupocontable = :idgrupocontable"),
    @NamedQuery(name = "Grupocontable.findByGrupocontable", query = "SELECT g FROM Grupocontable g WHERE g.grupocontable = :grupocontable")})
public class Grupocontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgrupocontable")
    private Integer idgrupocontable;
    @Size(max = 100)
    @Column(name = "grupocontable")
    private String grupocontable;
    @OneToMany(mappedBy = "idgrupocontable")
    private Collection<Especificocontable> especificocontableCollection;
    @OneToMany(mappedBy = "idgrupocontable")
    private Collection<Plandecuenta> plandecuentaCollection;
    @OneToMany(mappedBy = "idgrupocontable")
    private Collection<Subespecificocontable> subespecificocontableCollection;
    @OneToMany(mappedBy = "idgrupocontable")
    private Collection<Subgrupocontable> subgrupocontableCollection;

    public Grupocontable() {
    }

    public Grupocontable(Integer idgrupocontable) {
        this.idgrupocontable = idgrupocontable;
    }

    public Integer getIdgrupocontable() {
        return idgrupocontable;
    }

    public void setIdgrupocontable(Integer idgrupocontable) {
        this.idgrupocontable = idgrupocontable;
    }

    public String getGrupocontable() {
        return grupocontable;
    }

    public void setGrupocontable(String grupocontable) {
        this.grupocontable = grupocontable;
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

    @XmlTransient
    public Collection<Subgrupocontable> getSubgrupocontableCollection() {
        return subgrupocontableCollection;
    }

    public void setSubgrupocontableCollection(Collection<Subgrupocontable> subgrupocontableCollection) {
        this.subgrupocontableCollection = subgrupocontableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupocontable != null ? idgrupocontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupocontable)) {
            return false;
        }
        Grupocontable other = (Grupocontable) object;
        if ((this.idgrupocontable == null && other.idgrupocontable != null) || (this.idgrupocontable != null && !this.idgrupocontable.equals(other.idgrupocontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return grupocontable;
    }
    
}
