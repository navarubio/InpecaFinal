/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "especificocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especificocontable.findAll", query = "SELECT e FROM Especificocontable e"),
    @NamedQuery(name = "Especificocontable.findByCodigocuenta", query = "SELECT e FROM Especificocontable e WHERE e.codigocuenta = :codigocuenta"),
    @NamedQuery(name = "Especificocontable.findByIdgrupocontable", query = "SELECT e FROM Especificocontable e WHERE e.idgrupocontable = :idgrupocontable"),
    @NamedQuery(name = "Especificocontable.findByIdsubgrupocontable", query = "SELECT e FROM Especificocontable e WHERE e.idsubgrupocontable = :idsubgrupocontable"),
    @NamedQuery(name = "Especificocontable.findByIdespecificocontable", query = "SELECT e FROM Especificocontable e WHERE e.idespecificocontable = :idespecificocontable"),
    @NamedQuery(name = "Especificocontable.findByEspecificocontable", query = "SELECT e FROM Especificocontable e WHERE e.especificocontable = :especificocontable")})
public class Especificocontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocuenta")
    private Integer codigocuenta;
    @Column(name = "idgrupocontable")
    private Integer idgrupocontable;
    @Column(name = "idsubgrupocontable")
    private Integer idsubgrupocontable;
    @Column(name = "idespecificocontable")
    private Integer idespecificocontable;
    @Size(max = 100)
    @Column(name = "especificocontable")
    private String especificocontable;

    public Especificocontable() {
    }

    public Especificocontable(Integer codigocuenta) {
        this.codigocuenta = codigocuenta;
    }

    public Integer getCodigocuenta() {
        return codigocuenta;
    }

    public void setCodigocuenta(Integer codigocuenta) {
        this.codigocuenta = codigocuenta;
    }

    public Integer getIdgrupocontable() {
        return idgrupocontable;
    }

    public void setIdgrupocontable(Integer idgrupocontable) {
        this.idgrupocontable = idgrupocontable;
    }

    public Integer getIdsubgrupocontable() {
        return idsubgrupocontable;
    }

    public void setIdsubgrupocontable(Integer idsubgrupocontable) {
        this.idsubgrupocontable = idsubgrupocontable;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocuenta != null ? codigocuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especificocontable)) {
            return false;
        }
        Especificocontable other = (Especificocontable) object;
        if ((this.codigocuenta == null && other.codigocuenta != null) || (this.codigocuenta != null && !this.codigocuenta.equals(other.codigocuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "("+ idespecificocontable+") "+ especificocontable;
    }
    
}
