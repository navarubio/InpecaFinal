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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cuentabancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentabancaria.findAll", query = "SELECT c FROM Cuentabancaria c"),
    @NamedQuery(name = "Cuentabancaria.findByIdcuentabancaria", query = "SELECT c FROM Cuentabancaria c WHERE c.idcuentabancaria = :idcuentabancaria"),
    @NamedQuery(name = "Cuentabancaria.findByNumerocuenta", query = "SELECT c FROM Cuentabancaria c WHERE c.numerocuenta = :numerocuenta"),
    @NamedQuery(name = "Cuentabancaria.findBySaldo", query = "SELECT c FROM Cuentabancaria c WHERE c.saldo = :saldo")})
public class Cuentabancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentabancaria")
    private Integer idcuentabancaria;
    @Size(max = 23)
    @Column(name = "numerocuenta")
    private String numerocuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @OneToMany(mappedBy = "idcuentabancaria")
    private Collection<Pagocompra> pagocompraCollection;
    @JoinColumn(name = "idbanco", referencedColumnName = "idbanco")
    @ManyToOne
    private Banco idbanco;
    @JoinColumn(name = "idplandecuenta", referencedColumnName = "idplandecuenta")
    @ManyToOne
    private Plandecuenta idplandecuenta;

    public Cuentabancaria() {
    }

    public Cuentabancaria(Integer idcuentabancaria) {
        this.idcuentabancaria = idcuentabancaria;
    }

    public Integer getIdcuentabancaria() {
        return idcuentabancaria;
    }

    public void setIdcuentabancaria(Integer idcuentabancaria) {
        this.idcuentabancaria = idcuentabancaria;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<Pagocompra> getPagocompraCollection() {
        return pagocompraCollection;
    }

    public void setPagocompraCollection(Collection<Pagocompra> pagocompraCollection) {
        this.pagocompraCollection = pagocompraCollection;
    }

    public Banco getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Banco idbanco) {
        this.idbanco = idbanco;
    }

    public Plandecuenta getIdplandecuenta() {
        return idplandecuenta;
    }

    public void setIdplandecuenta(Plandecuenta idplandecuenta) {
        this.idplandecuenta = idplandecuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentabancaria != null ? idcuentabancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentabancaria)) {
            return false;
        }
        Cuentabancaria other = (Cuentabancaria) object;
        if ((this.idcuentabancaria == null && other.idcuentabancaria != null) || (this.idcuentabancaria != null && !this.idcuentabancaria.equals(other.idcuentabancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Cuentabancaria[ idcuentabancaria=" + idcuentabancaria + " ]";
    }
    
}
