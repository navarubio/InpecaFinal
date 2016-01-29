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
@Table(name = "deposito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d"),
    @NamedQuery(name = "Deposito.findByIddeposito", query = "SELECT d FROM Deposito d WHERE d.iddeposito = :iddeposito"),
    @NamedQuery(name = "Deposito.findByNombredeposito", query = "SELECT d FROM Deposito d WHERE d.nombredeposito = :nombredeposito")})
public class Deposito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddeposito")
    private Integer iddeposito;
    @Size(max = 40)
    @Column(name = "nombredeposito")
    private String nombredeposito;

    public Deposito() {
    }

    public Deposito(Integer iddeposito) {
        this.iddeposito = iddeposito;
    }

    public Integer getIddeposito() {
        return iddeposito;
    }

    public void setIddeposito(Integer iddeposito) {
        this.iddeposito = iddeposito;
    }

    public String getNombredeposito() {
        return nombredeposito;
    }

    public void setNombredeposito(String nombredeposito) {
        this.nombredeposito = nombredeposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddeposito != null ? iddeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.iddeposito == null && other.iddeposito != null) || (this.iddeposito != null && !this.iddeposito.equals(other.iddeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Deposito[ iddeposito=" + iddeposito + " ]";
    }
    
}
