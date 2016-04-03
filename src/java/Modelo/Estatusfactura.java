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
@Table(name = "estatusfactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estatusfactura.findAll", query = "SELECT e FROM Estatusfactura e"),
    @NamedQuery(name = "Estatusfactura.findByIdestatusfactura", query = "SELECT e FROM Estatusfactura e WHERE e.idestatusfactura = :idestatusfactura"),
    @NamedQuery(name = "Estatusfactura.findByEstatusfactura", query = "SELECT e FROM Estatusfactura e WHERE e.estatusfactura = :estatusfactura")})
public class Estatusfactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestatusfactura")
    private Integer idestatusfactura;
    @Size(max = 40)
    @Column(name = "estatusfactura")
    private String estatusfactura;
    @OneToMany(mappedBy = "idestatusfactura")
    private Collection<Compra> compraCollection;

    public Estatusfactura() {
    }

    public Estatusfactura(Integer idestatusfactura) {
        this.idestatusfactura = idestatusfactura;
    }

    public Integer getIdestatusfactura() {
        return idestatusfactura;
    }

    public void setIdestatusfactura(Integer idestatusfactura) {
        this.idestatusfactura = idestatusfactura;
    }

    public String getEstatusfactura() {
        return estatusfactura;
    }

    public void setEstatusfactura(String estatusfactura) {
        this.estatusfactura = estatusfactura;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestatusfactura != null ? idestatusfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estatusfactura)) {
            return false;
        }
        Estatusfactura other = (Estatusfactura) object;
        if ((this.idestatusfactura == null && other.idestatusfactura != null) || (this.idestatusfactura != null && !this.idestatusfactura.equals(other.idestatusfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return estatusfactura;
    }
    
}
