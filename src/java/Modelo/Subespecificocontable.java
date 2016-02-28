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
@Table(name = "subespecificocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subespecificocontable.findAll", query = "SELECT s FROM Subespecificocontable s"),
    @NamedQuery(name = "Subespecificocontable.findByIdsubespecificocontable", query = "SELECT s FROM Subespecificocontable s WHERE s.idsubespecificocontable = :idsubespecificocontable"),
    @NamedQuery(name = "Subespecificocontable.findBySubespecificocontable", query = "SELECT s FROM Subespecificocontable s WHERE s.subespecificocontable = :subespecificocontable")})
public class Subespecificocontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsubespecificocontable")
    private Integer idsubespecificocontable;
    @Size(max = 100)
    @Column(name = "subespecificocontable")
    private String subespecificocontable;
    @OneToMany(mappedBy = "idsubespecificocontable")
    private Collection<Plandecuenta> plandecuentaCollection;
    @JoinColumn(name = "idgrupocontable", referencedColumnName = "idgrupocontable")
    @ManyToOne
    private Grupocontable idgrupocontable;
    @JoinColumn(name = "idsubgrupocontable", referencedColumnName = "idsubgrupocontable")
    @ManyToOne
    private Subgrupocontable idsubgrupocontable;
    @JoinColumn(name = "idespecificocontable", referencedColumnName = "idespecificocontable")
    @ManyToOne
    private Especificocontable idespecificocontable;

    public Subespecificocontable() {
    }

    public Subespecificocontable(Integer idsubespecificocontable) {
        this.idsubespecificocontable = idsubespecificocontable;
    }

    public Integer getIdsubespecificocontable() {
        return idsubespecificocontable;
    }

    public void setIdsubespecificocontable(Integer idsubespecificocontable) {
        this.idsubespecificocontable = idsubespecificocontable;
    }

    public String getSubespecificocontable() {
        return subespecificocontable;
    }

    public void setSubespecificocontable(String subespecificocontable) {
        this.subespecificocontable = subespecificocontable;
    }

    @XmlTransient
    public Collection<Plandecuenta> getPlandecuentaCollection() {
        return plandecuentaCollection;
    }

    public void setPlandecuentaCollection(Collection<Plandecuenta> plandecuentaCollection) {
        this.plandecuentaCollection = plandecuentaCollection;
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

    public Especificocontable getIdespecificocontable() {
        return idespecificocontable;
    }

    public void setIdespecificocontable(Especificocontable idespecificocontable) {
        this.idespecificocontable = idespecificocontable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubespecificocontable != null ? idsubespecificocontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subespecificocontable)) {
            return false;
        }
        Subespecificocontable other = (Subespecificocontable) object;
        if ((this.idsubespecificocontable == null && other.idsubespecificocontable != null) || (this.idsubespecificocontable != null && !this.idsubespecificocontable.equals(other.idsubespecificocontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return subespecificocontable;
    }
    
}
