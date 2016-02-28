/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdcompra", query = "SELECT c FROM Compra c WHERE c.idcompra = :idcompra"),
    @NamedQuery(name = "Compra.findByFechaorden", query = "SELECT c FROM Compra c WHERE c.fechaorden = :fechaorden"),
    @NamedQuery(name = "Compra.findBySubtotal", query = "SELECT c FROM Compra c WHERE c.subtotal = :subtotal"),
    @NamedQuery(name = "Compra.findByIva", query = "SELECT c FROM Compra c WHERE c.iva = :iva"),
    @NamedQuery(name = "Compra.findByTotal", query = "SELECT c FROM Compra c WHERE c.total = :total"),
    @NamedQuery(name = "Compra.findByObservacionescompra", query = "SELECT c FROM Compra c WHERE c.observacionescompra = :observacionescompra"),
    @NamedQuery(name = "Compra.findByNumerofactura", query = "SELECT c FROM Compra c WHERE c.numerofactura = :numerofactura"),
    @NamedQuery(name = "Compra.findByControlfactura", query = "SELECT c FROM Compra c WHERE c.controlfactura = :controlfactura"),
    @NamedQuery(name = "Compra.findByFechafactura", query = "SELECT c FROM Compra c WHERE c.fechafactura = :fechafactura"),
    @NamedQuery(name = "Compra.findByObservacionespago", query = "SELECT c FROM Compra c WHERE c.observacionespago = :observacionespago")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompra")
    private Integer idcompra;
    @Column(name = "fechaorden")
    @Temporal(TemporalType.DATE)
    private Date fechaorden;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "iva")
    private Double iva;
    @Column(name = "total")
    private Double total;
    @Size(max = 255)
    @Column(name = "observacionescompra")
    private String observacionescompra;
    @Size(max = 10)
    @Column(name = "numerofactura")
    private String numerofactura;
    @Size(max = 15)
    @Column(name = "controlfactura")
    private String controlfactura;
    @Column(name = "fechafactura")
    @Temporal(TemporalType.DATE)
    private Date fechafactura;
    @Size(max = 255)
    @Column(name = "observacionespago")
    private String observacionespago;
    @JoinColumn(name = "idauxiliarrequerimiento", referencedColumnName = "idauxiliarrequerimiento")
    @ManyToOne
    private Auxiliarrequerimiento idauxiliarrequerimiento;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;
    @JoinColumn(name = "rifproveedor", referencedColumnName = "rifproveedor")
    @ManyToOne
    private Proveedor rifproveedor;
    @JoinColumn(name = "idestatusfactura", referencedColumnName = "idestatusfactura")
    @ManyToOne
    private Estatusfactura idestatusfactura;
    @OneToMany(mappedBy = "idcompra")
    private Collection<Detallecompra> detallecompraCollection;

    public Compra() {
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Date getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getObservacionescompra() {
        return observacionescompra;
    }

    public void setObservacionescompra(String observacionescompra) {
        this.observacionescompra = observacionescompra;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public String getControlfactura() {
        return controlfactura;
    }

    public void setControlfactura(String controlfactura) {
        this.controlfactura = controlfactura;
    }

    public Date getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    public String getObservacionespago() {
        return observacionespago;
    }

    public void setObservacionespago(String observacionespago) {
        this.observacionespago = observacionespago;
    }

    public Auxiliarrequerimiento getIdauxiliarrequerimiento() {
        return idauxiliarrequerimiento;
    }

    public void setIdauxiliarrequerimiento(Auxiliarrequerimiento idauxiliarrequerimiento) {
        this.idauxiliarrequerimiento = idauxiliarrequerimiento;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Proveedor getRifproveedor() {
        return rifproveedor;
    }

    public void setRifproveedor(Proveedor rifproveedor) {
        this.rifproveedor = rifproveedor;
    }

    public Estatusfactura getIdestatusfactura() {
        return idestatusfactura;
    }

    public void setIdestatusfactura(Estatusfactura idestatusfactura) {
        this.idestatusfactura = idestatusfactura;
    }

    @XmlTransient
    public Collection<Detallecompra> getDetallecompraCollection() {
        return detallecompraCollection;
    }

    public void setDetallecompraCollection(Collection<Detallecompra> detallecompraCollection) {
        this.detallecompraCollection = detallecompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Compra[ idcompra=" + idcompra + " ]";
    }
    
}
