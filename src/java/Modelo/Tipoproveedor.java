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
@Table(name = "tipoproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoproveedor.findAll", query = "SELECT t FROM Tipoproveedor t"),
    @NamedQuery(name = "Tipoproveedor.findByIdtipoproveedor", query = "SELECT t FROM Tipoproveedor t WHERE t.idtipoproveedor = :idtipoproveedor"),
    @NamedQuery(name = "Tipoproveedor.findByTipoproveedor", query = "SELECT t FROM Tipoproveedor t WHERE t.tipoproveedor = :tipoproveedor")})
public class Tipoproveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoproveedor")
    private Integer idtipoproveedor;
    @Size(max = 20)
    @Column(name = "tipoproveedor")
    private String tipoproveedor;
    @OneToMany(mappedBy = "idtipoproveedor")
    private Collection<Proveedor> proveedorCollection;

    public Tipoproveedor() {
    }

    public Tipoproveedor(Integer idtipoproveedor) {
        this.idtipoproveedor = idtipoproveedor;
    }

    public Integer getIdtipoproveedor() {
        return idtipoproveedor;
    }

    public void setIdtipoproveedor(Integer idtipoproveedor) {
        this.idtipoproveedor = idtipoproveedor;
    }

    public String getTipoproveedor() {
        return tipoproveedor;
    }

    public void setTipoproveedor(String tipoproveedor) {
        this.tipoproveedor = tipoproveedor;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoproveedor != null ? idtipoproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoproveedor)) {
            return false;
        }
        Tipoproveedor other = (Tipoproveedor) object;
        if ((this.idtipoproveedor == null && other.idtipoproveedor != null) || (this.idtipoproveedor != null && !this.idtipoproveedor.equals(other.idtipoproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoproveedor;
    }
    
}
