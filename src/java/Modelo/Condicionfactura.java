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
@Table(name = "condicionfactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condicionfactura.findAll", query = "SELECT c FROM Condicionfactura c"),
    @NamedQuery(name = "Condicionfactura.findByIdcondicionfactura", query = "SELECT c FROM Condicionfactura c WHERE c.idcondicionfactura = :idcondicionfactura"),
    @NamedQuery(name = "Condicionfactura.findByCondicionfactura", query = "SELECT c FROM Condicionfactura c WHERE c.condicionfactura = :condicionfactura")})
public class Condicionfactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcondicionfactura")
    private Integer idcondicionfactura;
    @Size(max = 20)
    @Column(name = "condicionfactura")
    private String condicionfactura;

    public Condicionfactura() {
    }

    public Condicionfactura(Integer idcondicionfactura) {
        this.idcondicionfactura = idcondicionfactura;
    }

    public Integer getIdcondicionfactura() {
        return idcondicionfactura;
    }

    public void setIdcondicionfactura(Integer idcondicionfactura) {
        this.idcondicionfactura = idcondicionfactura;
    }

    public String getCondicionfactura() {
        return condicionfactura;
    }

    public void setCondicionfactura(String condicionfactura) {
        this.condicionfactura = condicionfactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcondicionfactura != null ? idcondicionfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condicionfactura)) {
            return false;
        }
        Condicionfactura other = (Condicionfactura) object;
        if ((this.idcondicionfactura == null && other.idcondicionfactura != null) || (this.idcondicionfactura != null && !this.idcondicionfactura.equals(other.idcondicionfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Condicionfactura[ idcondicionfactura=" + idcondicionfactura + " ]";
    }
    
}
