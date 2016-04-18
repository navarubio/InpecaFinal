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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "retencionpago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retencionpago.findAll", query = "SELECT r FROM Retencionpago r"),
    @NamedQuery(name = "Retencionpago.findByIdretencionpago", query = "SELECT r FROM Retencionpago r WHERE r.idretencionpago = :idretencionpago"),
    @NamedQuery(name = "Retencionpago.findByMontocompra", query = "SELECT r FROM Retencionpago r WHERE r.montocompra = :montocompra"),
    @NamedQuery(name = "Retencionpago.findByRetencionislr", query = "SELECT r FROM Retencionpago r WHERE r.retencionislr = :retencionislr"),
    @NamedQuery(name = "Retencionpago.findByComprobante", query = "SELECT r FROM Retencionpago r WHERE r.comprobante = :comprobante")})
public class Retencionpago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idretencionpago")
    private Integer idretencionpago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montocompra")
    private Double montocompra;
    @Column(name = "retencionislr")
    private Double retencionislr;
    @Size(max = 15)
    @Column(name = "comprobante")
    private String comprobante;
    @JoinColumn(name = "idpagocompra", referencedColumnName = "idpagocompra")
    @ManyToOne
    private Pagocompra idpagocompra;
    @JoinColumn(name = "idplandecuenta", referencedColumnName = "idplandecuenta")
    @ManyToOne
    private Plandecuenta idplandecuenta;

    public Retencionpago() {
    }

    public Retencionpago(Integer idretencionpago) {
        this.idretencionpago = idretencionpago;
    }

    public Integer getIdretencionpago() {
        return idretencionpago;
    }

    public void setIdretencionpago(Integer idretencionpago) {
        this.idretencionpago = idretencionpago;
    }

    public Double getMontocompra() {
        return montocompra;
    }

    public void setMontocompra(Double montocompra) {
        this.montocompra = montocompra;
    }

    public Double getRetencionislr() {
        return retencionislr;
    }

    public void setRetencionislr(Double retencionislr) {
        this.retencionislr = retencionislr;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public Pagocompra getIdpagocompra() {
        return idpagocompra;
    }

    public void setIdpagocompra(Pagocompra idpagocompra) {
        this.idpagocompra = idpagocompra;
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
        hash += (idretencionpago != null ? idretencionpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retencionpago)) {
            return false;
        }
        Retencionpago other = (Retencionpago) object;
        if ((this.idretencionpago == null && other.idretencionpago != null) || (this.idretencionpago != null && !this.idretencionpago.equals(other.idretencionpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Retencionpago[ idretencionpago=" + idretencionpago + " ]";
    }
    
}
