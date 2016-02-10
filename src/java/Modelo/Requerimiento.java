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
@Table(name = "requerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requerimiento.findAll", query = "SELECT r FROM Requerimiento r"),
    @NamedQuery(name = "Requerimiento.findByIdrequerimiento", query = "SELECT r FROM Requerimiento r WHERE r.idrequerimiento = :idrequerimiento"),
    @NamedQuery(name = "Requerimiento.findByCantidad", query = "SELECT r FROM Requerimiento r WHERE r.cantidad = :cantidad"),
    @NamedQuery(name = "Requerimiento.findByPcosto", query = "SELECT r FROM Requerimiento r WHERE r.pcosto = :pcosto")})
public class Requerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrequerimiento")
    private Integer idrequerimiento;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pcosto")
    private Double pcosto;
    @Column(name = "subtotal")
    private Double subtotal;    
    @Column(name = "tributoiva")
    private Double tributoiva;
    @Column(name = "total")
    private Double total;
    
    @JoinColumn(name = "idauxiliarrequerimiento", referencedColumnName = "idauxiliarrequerimiento")
    @ManyToOne
    private Auxiliarrequerimiento idauxiliarrequerimiento;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Articulo codigo;

    public Requerimiento() {
    }

    public Requerimiento(Integer idrequerimiento) {
        this.idrequerimiento = idrequerimiento;
    }

    public Integer getIdrequerimiento() {
        return idrequerimiento;
    }

    public void setIdrequerimiento(Integer idrequerimiento) {
        this.idrequerimiento = idrequerimiento;
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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    
    public Double getTributoiva() {
        return tributoiva;
    }

    public void setTributoiva(Double tributoiva) {
        this.tributoiva = tributoiva;
    }
    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Auxiliarrequerimiento getIdauxiliarrequerimiento() {
        return idauxiliarrequerimiento;
    }

    public void setIdauxiliarrequerimiento(Auxiliarrequerimiento idauxiliarrequerimiento) {
        this.idauxiliarrequerimiento = idauxiliarrequerimiento;
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
        hash += (idrequerimiento != null ? idrequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerimiento)) {
            return false;
        }
        Requerimiento other = (Requerimiento) object;
        if ((this.idrequerimiento == null && other.idrequerimiento != null) || (this.idrequerimiento != null && !this.idrequerimiento.equals(other.idrequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Requerimiento[ idrequerimiento=" + idrequerimiento + " ]";
    }
    
}
