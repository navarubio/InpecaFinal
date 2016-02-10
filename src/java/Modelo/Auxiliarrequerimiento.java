/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "auxiliarrequerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auxiliarrequerimiento.findAll", query = "SELECT a FROM Auxiliarrequerimiento a"),
    @NamedQuery(name = "Auxiliarrequerimiento.findByIdauxiliarrequerimiento", query = "SELECT a FROM Auxiliarrequerimiento a WHERE a.idauxiliarrequerimiento = :idauxiliarrequerimiento"),
    @NamedQuery(name = "Auxiliarrequerimiento.findByPosibleproveedor", query = "SELECT a FROM Auxiliarrequerimiento a WHERE a.posibleproveedor = :posibleproveedor"),
    @NamedQuery(name = "Auxiliarrequerimiento.findByTelefonoproveedor", query = "SELECT a FROM Auxiliarrequerimiento a WHERE a.telefonoproveedor = :telefonoproveedor"),
    @NamedQuery(name = "Auxiliarrequerimiento.findByDescripcion", query = "SELECT a FROM Auxiliarrequerimiento a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Auxiliarrequerimiento.findByFecharequerimiento", query = "SELECT a FROM Auxiliarrequerimiento a WHERE a.fecharequerimiento = :fecharequerimiento")})
public class Auxiliarrequerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauxiliarrequerimiento")
    private Integer idauxiliarrequerimiento;
    @Size(max = 100)
    @Column(name = "posibleproveedor")
    private String posibleproveedor;
    @Size(max = 50)
    @Column(name = "telefonoproveedor")
    private String telefonoproveedor;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecharequerimiento")
    @Temporal(TemporalType.DATE)
    private Date fecharequerimiento;
    @Column(name = "montototal")
    private Double montototal;
    
    @JoinColumn(name = "idestatusrequerimiento", referencedColumnName = "idestatusrequerimiento")
    @ManyToOne
    private Estatusrequerimiento idestatusrequerimiento;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;
    @JoinColumn(name = "iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne
    private Departamento iddepartamento;

    public Auxiliarrequerimiento() {
    }

    public Auxiliarrequerimiento(Integer idauxiliarrequerimiento) {
        this.idauxiliarrequerimiento = idauxiliarrequerimiento;
    }

    public Integer getIdauxiliarrequerimiento() {
        return idauxiliarrequerimiento;
    }

    public void setIdauxiliarrequerimiento(Integer idauxiliarrequerimiento) {
        this.idauxiliarrequerimiento = idauxiliarrequerimiento;
    }

    public String getPosibleproveedor() {
        return posibleproveedor;
    }

    public void setPosibleproveedor(String posibleproveedor) {
        this.posibleproveedor = posibleproveedor;
    }

    public String getTelefonoproveedor() {
        return telefonoproveedor;
    }

    public void setTelefonoproveedor(String telefonoproveedor) {
        this.telefonoproveedor = telefonoproveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecharequerimiento() {
        return fecharequerimiento;
    }

    public void setFecharequerimiento(Date fecharequerimiento) {
        this.fecharequerimiento = fecharequerimiento;
    }

    public Double getMontototal() {
        return montototal;
    }

    public void setMontototal(Double montototal) {
        this.montototal = montototal;
    }

    
    public Estatusrequerimiento getIdestatusrequerimiento() {
        return idestatusrequerimiento;
    }

    public void setIdestatusrequerimiento(Estatusrequerimiento idestatusrequerimiento) {
        this.idestatusrequerimiento = idestatusrequerimiento;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Departamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Departamento iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauxiliarrequerimiento != null ? idauxiliarrequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auxiliarrequerimiento)) {
            return false;
        }
        Auxiliarrequerimiento other = (Auxiliarrequerimiento) object;
        if ((this.idauxiliarrequerimiento == null && other.idauxiliarrequerimiento != null) || (this.idauxiliarrequerimiento != null && !this.idauxiliarrequerimiento.equals(other.idauxiliarrequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Auxiliarrequerimiento[ idauxiliarrequerimiento=" + idauxiliarrequerimiento + " ]";
    }
    
}
