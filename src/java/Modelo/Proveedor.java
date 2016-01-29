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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inpeca
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByRifproveedor", query = "SELECT p FROM Proveedor p WHERE p.rifproveedor = :rifproveedor"),
    @NamedQuery(name = "Proveedor.findByRazonsocial", query = "SELECT p FROM Proveedor p WHERE p.razonsocial = :razonsocial"),
    @NamedQuery(name = "Proveedor.findByDireccionfiscal", query = "SELECT p FROM Proveedor p WHERE p.direccionfiscal = :direccionfiscal"),
    @NamedQuery(name = "Proveedor.findByTelefonos", query = "SELECT p FROM Proveedor p WHERE p.telefonos = :telefonos"),
    @NamedQuery(name = "Proveedor.findByCorreo", query = "SELECT p FROM Proveedor p WHERE p.correo = :correo"),
    @NamedQuery(name = "Proveedor.findByFechainscripcion", query = "SELECT p FROM Proveedor p WHERE p.fechainscripcion = :fechainscripcion"),
    @NamedQuery(name = "Proveedor.findByPersonacontacto", query = "SELECT p FROM Proveedor p WHERE p.personacontacto = :personacontacto"),
    @NamedQuery(name = "Proveedor.findByTelefonocontacto", query = "SELECT p FROM Proveedor p WHERE p.telefonocontacto = :telefonocontacto")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rifproveedor")
    private String rifproveedor;
    @Size(max = 100)
    @Column(name = "razonsocial")
    private String razonsocial;
    @Size(max = 200)
    @Column(name = "direccionfiscal")
    private String direccionfiscal;
    @Size(max = 50)
    @Column(name = "telefonos")
    private String telefonos;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechainscripcion;
    @Size(max = 150)
    @Column(name = "personacontacto")
    private String personacontacto;
    @Size(max = 50)
    @Column(name = "telefonocontacto")
    private String telefonocontacto;
    @JoinColumn(name = "idtipoproveedor", referencedColumnName = "idtipoproveedor")
    @ManyToOne
    private Tipoproveedor idtipoproveedor;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;
    @JoinColumn(name = "idpersonalidad", referencedColumnName = "idpersonalidad")
    @ManyToOne
    private Personalidadjuridica idpersonalidad;

    public Proveedor() {
    }

    public Proveedor(String rifproveedor) {
        this.rifproveedor = rifproveedor;
    }

    public String getRifproveedor() {
        return rifproveedor;
    }

    public void setRifproveedor(String rifproveedor) {
        this.rifproveedor = rifproveedor;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccionfiscal() {
        return direccionfiscal;
    }

    public void setDireccionfiscal(String direccionfiscal) {
        this.direccionfiscal = direccionfiscal;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public String getPersonacontacto() {
        return personacontacto;
    }

    public void setPersonacontacto(String personacontacto) {
        this.personacontacto = personacontacto;
    }

    public String getTelefonocontacto() {
        return telefonocontacto;
    }

    public void setTelefonocontacto(String telefonocontacto) {
        this.telefonocontacto = telefonocontacto;
    }

    public Tipoproveedor getIdtipoproveedor() {
        return idtipoproveedor;
    }

    public void setIdtipoproveedor(Tipoproveedor idtipoproveedor) {
        this.idtipoproveedor = idtipoproveedor;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Personalidadjuridica getIdpersonalidad() {
        return idpersonalidad;
    }

    public void setIdpersonalidad(Personalidadjuridica idpersonalidad) {
        this.idpersonalidad = idpersonalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rifproveedor != null ? rifproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.rifproveedor == null && other.rifproveedor != null) || (this.rifproveedor != null && !this.rifproveedor.equals(other.rifproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Proveedor[ rifproveedor=" + rifproveedor + " ]";
    }
    
}
