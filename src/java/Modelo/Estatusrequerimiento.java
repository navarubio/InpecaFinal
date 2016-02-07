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
@Table(name = "estatusrequerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estatusrequerimiento.findAll", query = "SELECT e FROM Estatusrequerimiento e"),
    @NamedQuery(name = "Estatusrequerimiento.findByIdestatusrequerimiento", query = "SELECT e FROM Estatusrequerimiento e WHERE e.idestatusrequerimiento = :idestatusrequerimiento"),
    @NamedQuery(name = "Estatusrequerimiento.findByEstatusrequerimiento", query = "SELECT e FROM Estatusrequerimiento e WHERE e.estatusrequerimiento = :estatusrequerimiento")})
public class Estatusrequerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestatusrequerimiento")
    private Integer idestatusrequerimiento;
    @Size(max = 40)
    @Column(name = "estatusrequerimiento")
    private String estatusrequerimiento;
    @OneToMany(mappedBy = "idestatusrequerimiento")
    private Collection<Auxiliarrequerimiento> auxiliarrequerimientoCollection;

    public Estatusrequerimiento() {
    }

    public Estatusrequerimiento(Integer idestatusrequerimiento) {
        this.idestatusrequerimiento = idestatusrequerimiento;
    }

    public Integer getIdestatusrequerimiento() {
        return idestatusrequerimiento;
    }

    public void setIdestatusrequerimiento(Integer idestatusrequerimiento) {
        this.idestatusrequerimiento = idestatusrequerimiento;
    }

    public String getEstatusrequerimiento() {
        return estatusrequerimiento;
    }

    public void setEstatusrequerimiento(String estatusrequerimiento) {
        this.estatusrequerimiento = estatusrequerimiento;
    }

    @XmlTransient
    public Collection<Auxiliarrequerimiento> getAuxiliarrequerimientoCollection() {
        return auxiliarrequerimientoCollection;
    }

    public void setAuxiliarrequerimientoCollection(Collection<Auxiliarrequerimiento> auxiliarrequerimientoCollection) {
        this.auxiliarrequerimientoCollection = auxiliarrequerimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestatusrequerimiento != null ? idestatusrequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estatusrequerimiento)) {
            return false;
        }
        Estatusrequerimiento other = (Estatusrequerimiento) object;
        if ((this.idestatusrequerimiento == null && other.idestatusrequerimiento != null) || (this.idestatusrequerimiento != null && !this.idestatusrequerimiento.equals(other.idestatusrequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return estatusrequerimiento;
    }
    
}
