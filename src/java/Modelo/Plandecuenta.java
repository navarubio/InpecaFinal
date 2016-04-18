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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "plandecuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plandecuenta.findAll", query = "SELECT p FROM Plandecuenta p"),
    @NamedQuery(name = "Plandecuenta.findByIdplandecuenta", query = "SELECT p FROM Plandecuenta p WHERE p.idplandecuenta = :idplandecuenta"),
    @NamedQuery(name = "Plandecuenta.findByIdgrupocontable", query = "SELECT p FROM Plandecuenta p WHERE p.idgrupocontable = :idgrupocontable"),
    @NamedQuery(name = "Plandecuenta.findByIdsubgrupocontable", query = "SELECT p FROM Plandecuenta p WHERE p.idsubgrupocontable = :idsubgrupocontable"),
    @NamedQuery(name = "Plandecuenta.findByIdespecificocontable", query = "SELECT p FROM Plandecuenta p WHERE p.idespecificocontable = :idespecificocontable"),
    @NamedQuery(name = "Plandecuenta.findByIdsubespecificocontable", query = "SELECT p FROM Plandecuenta p WHERE p.idsubespecificocontable = :idsubespecificocontable"),
    @NamedQuery(name = "Plandecuenta.findByIdgeneralcuenta", query = "SELECT p FROM Plandecuenta p WHERE p.idgeneralcuenta = :idgeneralcuenta"),
    @NamedQuery(name = "Plandecuenta.findByDescripcioncuenta", query = "SELECT p FROM Plandecuenta p WHERE p.descripcioncuenta = :descripcioncuenta"),
    @NamedQuery(name = "Plandecuenta.findBySaldogeneral", query = "SELECT p FROM Plandecuenta p WHERE p.saldogeneral = :saldogeneral"),
    @NamedQuery(name = "Plandecuenta.findByFujodeefectivo", query = "SELECT p FROM Plandecuenta p WHERE p.fujodeefectivo = :fujodeefectivo")})
public class Plandecuenta implements Serializable {
    @OneToMany(mappedBy = "idplandecuenta")
    private Collection<Retencionpago> retencionpagoCollection;
    @OneToMany(mappedBy = "idplandecuenta")
    private Collection<Pagocompra> pagocompraCollection;
    @OneToMany(mappedBy = "idplandecuenta")
    private Collection<Cuentabancaria> cuentabancariaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idplandecuenta")
    private Integer idplandecuenta;
    @Column(name = "idgrupocontable")
    private Integer idgrupocontable;
    @Column(name = "idsubgrupocontable")
    private Integer idsubgrupocontable;
    @Column(name = "idespecificocontable")
    private Integer idespecificocontable;
    @Column(name = "idsubespecificocontable")
    private Integer idsubespecificocontable;
    @Column(name = "idgeneralcuenta")
    private Integer idgeneralcuenta;
    @Size(max = 200)
    @Column(name = "descripcioncuenta")
    private String descripcioncuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldogeneral")
    private Double saldogeneral;
    @Column(name = "fujodeefectivo")
    private Integer fujodeefectivo;
    @JoinColumn(name = "idtipocuentacontable", referencedColumnName = "idtipocuentacontable")
    @ManyToOne
    private Tipocuentacontable idtipocuentacontable;
    @JoinColumn(name = "idtiposaldocontable", referencedColumnName = "idtiposaldocontable")
    @ManyToOne
    private Tiposaldocontable idtiposaldocontable;
    @JoinColumn(name = "idtipopartidacontable", referencedColumnName = "idtipopartidacontable")
    @ManyToOne
    private Tipopartidacontable idtipopartidacontable;

    public Plandecuenta() {
    }

    public Plandecuenta(Integer idplandecuenta) {
        this.idplandecuenta = idplandecuenta;
    }

    public Integer getIdplandecuenta() {
        return idplandecuenta;
    }

    public void setIdplandecuenta(Integer idplandecuenta) {
        this.idplandecuenta = idplandecuenta;
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

    public Integer getIdgeneralcuenta() {
        return idgeneralcuenta;
    }

    public void setIdgeneralcuenta(Integer idgeneralcuenta) {
        this.idgeneralcuenta = idgeneralcuenta;
    }

    public String getDescripcioncuenta() {
        return descripcioncuenta;
    }

    public void setDescripcioncuenta(String descripcioncuenta) {
        this.descripcioncuenta = descripcioncuenta;
    }

    public Double getSaldogeneral() {
        return saldogeneral;
    }

    public void setSaldogeneral(Double saldogeneral) {
        this.saldogeneral = saldogeneral;
    }

    public Integer getFujodeefectivo() {
        return fujodeefectivo;
    }

    public void setFujodeefectivo(Integer fujodeefectivo) {
        this.fujodeefectivo = fujodeefectivo;
    }

    public Tipocuentacontable getIdtipocuentacontable() {
        return idtipocuentacontable;
    }

    public void setIdtipocuentacontable(Tipocuentacontable idtipocuentacontable) {
        this.idtipocuentacontable = idtipocuentacontable;
    }

    public Tiposaldocontable getIdtiposaldocontable() {
        return idtiposaldocontable;
    }

    public void setIdtiposaldocontable(Tiposaldocontable idtiposaldocontable) {
        this.idtiposaldocontable = idtiposaldocontable;
    }

    public Tipopartidacontable getIdtipopartidacontable() {
        return idtipopartidacontable;
    }

    public void setIdtipopartidacontable(Tipopartidacontable idtipopartidacontable) {
        this.idtipopartidacontable = idtipopartidacontable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplandecuenta != null ? idplandecuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plandecuenta)) {
            return false;
        }
        Plandecuenta other = (Plandecuenta) object;
        if ((this.idplandecuenta == null && other.idplandecuenta != null) || (this.idplandecuenta != null && !this.idplandecuenta.equals(other.idplandecuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idplandecuenta + " " +descripcioncuenta;
    }

    @XmlTransient
    public Collection<Retencionpago> getRetencionpagoCollection() {
        return retencionpagoCollection;
    }

    public void setRetencionpagoCollection(Collection<Retencionpago> retencionpagoCollection) {
        this.retencionpagoCollection = retencionpagoCollection;
    }

    @XmlTransient
    public Collection<Pagocompra> getPagocompraCollection() {
        return pagocompraCollection;
    }

    public void setPagocompraCollection(Collection<Pagocompra> pagocompraCollection) {
        this.pagocompraCollection = pagocompraCollection;
    }

    @XmlTransient
    public Collection<Cuentabancaria> getCuentabancariaCollection() {
        return cuentabancariaCollection;
    }

    public void setCuentabancariaCollection(Collection<Cuentabancaria> cuentabancariaCollection) {
        this.cuentabancariaCollection = cuentabancariaCollection;
    }
    
}
