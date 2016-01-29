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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "tipopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopago.findAll", query = "SELECT t FROM Tipopago t"),
    @NamedQuery(name = "Tipopago.findByIdtipopago", query = "SELECT t FROM Tipopago t WHERE t.idtipopago = :idtipopago"),
    @NamedQuery(name = "Tipopago.findByTipopago", query = "SELECT t FROM Tipopago t WHERE t.tipopago = :tipopago")})
public class Tipopago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipopago")
    private Integer idtipopago;
    @Size(max = 20)
    @Column(name = "tipopago")
    private String tipopago;

    public Tipopago() {
    }

    public Tipopago(Integer idtipopago) {
        this.idtipopago = idtipopago;
    }

    public Integer getIdtipopago() {
        return idtipopago;
    }

    public void setIdtipopago(Integer idtipopago) {
        this.idtipopago = idtipopago;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipopago != null ? idtipopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopago)) {
            return false;
        }
        Tipopago other = (Tipopago) object;
        if ((this.idtipopago == null && other.idtipopago != null) || (this.idtipopago != null && !this.idtipopago.equals(other.idtipopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tipopago[ idtipopago=" + idtipopago + " ]";
    }
    
}
