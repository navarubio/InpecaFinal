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
@Table(name = "subespecificocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subespecificocontable.findAll", query = "SELECT s FROM Subespecificocontable s"),
    @NamedQuery(name = "Subespecificocontable.findByCodigocuenta", query = "SELECT s FROM Subespecificocontable s WHERE s.codigocuenta = :codigocuenta"),
    @NamedQuery(name = "Subespecificocontable.findByIdgrupocontable", query = "SELECT s FROM Subespecificocontable s WHERE s.idgrupocontable = :idgrupocontable"),
    @NamedQuery(name = "Subespecificocontable.findByIdsubgrupocontable", query = "SELECT s FROM Subespecificocontable s WHERE s.idsubgrupocontable = :idsubgrupocontable"),
    @NamedQuery(name = "Subespecificocontable.findByIdespecificocontable", query = "SELECT s FROM Subespecificocontable s WHERE s.idespecificocontable = :idespecificocontable"),
    @NamedQuery(name = "Subespecificocontable.findByIdsubespecificocontable", query = "SELECT s FROM Subespecificocontable s WHERE s.idsubespecificocontable = :idsubespecificocontable"),
    @NamedQuery(name = "Subespecificocontable.findBySubespecificocontable", query = "SELECT s FROM Subespecificocontable s WHERE s.subespecificocontable = :subespecificocontable")})
public class Subespecificocontable implements Serializable {
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
    @Column(name = "idsubespecificocontable")
    private Integer idsubespecificocontable;
    @Size(max = 100)
    @Column(name = "subespecificocontable")
    private String subespecificocontable;

    public Subespecificocontable() {
    }

    public Subespecificocontable(Integer codigocuenta) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocuenta != null ? codigocuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subespecificocontable)) {
            return false;
        }
        Subespecificocontable other = (Subespecificocontable) object;
        if ((this.codigocuenta == null && other.codigocuenta != null) || (this.codigocuenta != null && !this.codigocuenta.equals(other.codigocuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "("+ idsubespecificocontable +") "+ subespecificocontable;
    }
    
}
