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
@Table(name = "contribuyente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contribuyente.findAll", query = "SELECT c FROM Contribuyente c"),
    @NamedQuery(name = "Contribuyente.findByIdcontribuyente", query = "SELECT c FROM Contribuyente c WHERE c.idcontribuyente = :idcontribuyente"),
    @NamedQuery(name = "Contribuyente.findByContribuyente", query = "SELECT c FROM Contribuyente c WHERE c.contribuyente = :contribuyente")})
public class Contribuyente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontribuyente")
    private Integer idcontribuyente;
    @Size(max = 15)
    @Column(name = "contribuyente")
    private String contribuyente;
    @OneToMany(mappedBy = "idcontribuyente")
    private Collection<Cliente> clienteCollection;

    public Contribuyente() {
    }

    public Contribuyente(Integer idcontribuyente) {
        this.idcontribuyente = idcontribuyente;
    }

    public Integer getIdcontribuyente() {
        return idcontribuyente;
    }

    public void setIdcontribuyente(Integer idcontribuyente) {
        this.idcontribuyente = idcontribuyente;
    }

    public String getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(String contribuyente) {
        this.contribuyente = contribuyente;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontribuyente != null ? idcontribuyente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contribuyente)) {
            return false;
        }
        Contribuyente other = (Contribuyente) object;
        if ((this.idcontribuyente == null && other.idcontribuyente != null) || (this.idcontribuyente != null && !this.idcontribuyente.equals(other.idcontribuyente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return contribuyente;
    }
    
}
