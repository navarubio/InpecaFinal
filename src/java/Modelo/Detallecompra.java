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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "detallecompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecompra.findAll", query = "SELECT d FROM Detallecompra d"),
    @NamedQuery(name = "Detallecompra.findByIddetallecompra", query = "SELECT d FROM Detallecompra d WHERE d.iddetallecompra = :iddetallecompra"),
    @NamedQuery(name = "Detallecompra.findByCantidad", query = "SELECT d FROM Detallecompra d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallecompra.findByPcosto", query = "SELECT d FROM Detallecompra d WHERE d.pcosto = :pcosto"),
    @NamedQuery(name = "Detallecompra.findByTributoiva", query = "SELECT d FROM Detallecompra d WHERE d.tributoiva = :tributoiva"),
    @NamedQuery(name = "Detallecompra.findByTotalapagar", query = "SELECT d FROM Detallecompra d WHERE d.totalapagar = :totalapagar")})
public class Detallecompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallecompra")
    private Integer iddetallecompra;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pcosto")
    private Double pcosto;
    @Column(name = "tributoiva")
    private Double tributoiva;
    @Column(name = "totalapagar")
    private Double totalapagar;
    @JoinColumn(name = "idcompra", referencedColumnName = "idcompra")
    @ManyToOne
    private Compra idcompra;
    @JoinColumn(name = "idestatuscontable", referencedColumnName = "idestatuscontable")
    @ManyToOne
    private Estatuscontable idestatuscontable;
    @JoinColumn(name = "idplandecuenta", referencedColumnName = "idplandecuenta")
    @ManyToOne
    private Plandecuenta idplandecuenta;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Articulo codigo;

    public Detallecompra() {
    }

    public Detallecompra(Integer iddetallecompra) {
        this.iddetallecompra = iddetallecompra;
    }

    public Integer getIddetallecompra() {
        return iddetallecompra;
    }

    public void setIddetallecompra(Integer iddetallecompra) {
        this.iddetallecompra = iddetallecompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPcosto() {
        return pcosto;
    }

    public void setPcosto(Double pcosto) {
        this.pcosto = pcosto;
    }

    public Double getTributoiva() {
        return tributoiva;
    }

    public void setTributoiva(Double tributoiva) {
        this.tributoiva = tributoiva;
    }

    public Double getTotalapagar() {
        return totalapagar;
    }

    public void setTotalapagar(Double totalapagar) {
        this.totalapagar = totalapagar;
    }

    public Compra getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Compra idcompra) {
        this.idcompra = idcompra;
    }

    public Estatuscontable getIdestatuscontable() {
        return idestatuscontable;
    }

    public void setIdestatuscontable(Estatuscontable idestatuscontable) {
        this.idestatuscontable = idestatuscontable;
    }

    public Plandecuenta getIdplandecuenta() {
        return idplandecuenta;
    }

    public void setIdplandecuenta(Plandecuenta idplandecuenta) {
        this.idplandecuenta = idplandecuenta;
    }

    public Articulo getCodigo() {
        return codigo;
    }

    public void setCodigo(Articulo codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallecompra != null ? iddetallecompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecompra)) {
            return false;
        }
        Detallecompra other = (Detallecompra) object;
        if ((this.iddetallecompra == null && other.iddetallecompra != null) || (this.iddetallecompra != null && !this.iddetallecompra.equals(other.iddetallecompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Detallecompra[ iddetallecompra=" + iddetallecompra + " ]";
    }
    
}
