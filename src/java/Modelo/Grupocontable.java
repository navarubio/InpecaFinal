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
@Table(name = "grupocontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupocontable.findAll", query = "SELECT g FROM Grupocontable g"),
    @NamedQuery(name = "Grupocontable.findByCodigocuenta", query = "SELECT g FROM Grupocontable g WHERE g.codigocuenta = :codigocuenta"),
    @NamedQuery(name = "Grupocontable.findByIdgrupocontable", query = "SELECT g FROM Grupocontable g WHERE g.idgrupocontable = :idgrupocontable"),
    @NamedQuery(name = "Grupocontable.findByGrupocontable", query = "SELECT g FROM Grupocontable g WHERE g.grupocontable = :grupocontable")})
public class Grupocontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocuenta")
    private Integer codigocuenta;
    @Column(name = "idgrupocontable")
    private Integer idgrupocontable;
    @Size(max = 100)
    @Column(name = "grupocontable")
    private String grupocontable;

    public Grupocontable() {
    }

    public Grupocontable(Integer codigocuenta) {
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

    public String getGrupocontable() {
        return grupocontable;
    }

    public void setGrupocontable(String grupocontable) {
        this.grupocontable = grupocontable;
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
        if (!(object instanceof Grupocontable)) {
            return false;
        }
        Grupocontable other = (Grupocontable) object;
        if ((this.codigocuenta == null && other.codigocuenta != null) || (this.codigocuenta != null && !this.codigocuenta.equals(other.codigocuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "("+ idgrupocontable+") "+grupocontable;
    }
    
}
