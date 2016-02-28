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
@Table(name = "estatuscontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estatuscontable.findAll", query = "SELECT e FROM Estatuscontable e"),
    @NamedQuery(name = "Estatuscontable.findByIdestatuscontable", query = "SELECT e FROM Estatuscontable e WHERE e.idestatuscontable = :idestatuscontable"),
    @NamedQuery(name = "Estatuscontable.findByEstatuscontable", query = "SELECT e FROM Estatuscontable e WHERE e.estatuscontable = :estatuscontable")})
public class Estatuscontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestatuscontable")
    private Integer idestatuscontable;
    @Size(max = 40)
    @Column(name = "estatuscontable")
    private String estatuscontable;
    @OneToMany(mappedBy = "idestatuscontable")
    private Collection<Detallecompra> detallecompraCollection;

    public Estatuscontable() {
    }

    public Estatuscontable(Integer idestatuscontable) {
        this.idestatuscontable = idestatuscontable;
    }

    public Integer getIdestatuscontable() {
        return idestatuscontable;
    }

    public void setIdestatuscontable(Integer idestatuscontable) {
        this.idestatuscontable = idestatuscontable;
    }

    public String getEstatuscontable() {
        return estatuscontable;
    }

    public void setEstatuscontable(String estatuscontable) {
        this.estatuscontable = estatuscontable;
    }

    @XmlTransient
    public Collection<Detallecompra> getDetallecompraCollection() {
        return detallecompraCollection;
    }

    public void setDetallecompraCollection(Collection<Detallecompra> detallecompraCollection) {
        this.detallecompraCollection = detallecompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestatuscontable != null ? idestatuscontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estatuscontable)) {
            return false;
        }
        Estatuscontable other = (Estatuscontable) object;
        if ((this.idestatuscontable == null && other.idestatuscontable != null) || (this.idestatuscontable != null && !this.idestatuscontable.equals(other.idestatuscontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Estatuscontable[ idestatuscontable=" + idestatuscontable + " ]";
    }
    
}
