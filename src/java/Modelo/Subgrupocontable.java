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
@Table(name = "subgrupocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subgrupocontable.findAll", query = "SELECT s FROM Subgrupocontable s"),
    @NamedQuery(name = "Subgrupocontable.findByCodigocuenta", query = "SELECT s FROM Subgrupocontable s WHERE s.codigocuenta = :codigocuenta"),
    @NamedQuery(name = "Subgrupocontable.findByIdgrupocontable", query = "SELECT s FROM Subgrupocontable s WHERE s.idgrupocontable = :idgrupocontable"),
    @NamedQuery(name = "Subgrupocontable.findByIdsubgrupocontable", query = "SELECT s FROM Subgrupocontable s WHERE s.idsubgrupocontable = :idsubgrupocontable"),
    @NamedQuery(name = "Subgrupocontable.findBySubgrupocontable", query = "SELECT s FROM Subgrupocontable s WHERE s.subgrupocontable = :subgrupocontable")})
public class Subgrupocontable implements Serializable {
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
    @Size(max = 100)
    @Column(name = "subgrupocontable")
    private String subgrupocontable;

    public Subgrupocontable() {
    }

    public Subgrupocontable(Integer codigocuenta) {
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

    public String getSubgrupocontable() {
        return subgrupocontable;
    }

    public void setSubgrupocontable(String subgrupocontable) {
        this.subgrupocontable = subgrupocontable;
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
        if (!(object instanceof Subgrupocontable)) {
            return false;
        }
        Subgrupocontable other = (Subgrupocontable) object;
        if ((this.codigocuenta == null && other.codigocuenta != null) || (this.codigocuenta != null && !this.codigocuenta.equals(other.codigocuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "("+ idsubgrupocontable+") "+ subgrupocontable;
    }
    
}
