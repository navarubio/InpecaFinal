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
@Table(name = "gravamen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gravamen.findAll", query = "SELECT g FROM Gravamen g"),
    @NamedQuery(name = "Gravamen.findByIdgravamen", query = "SELECT g FROM Gravamen g WHERE g.idgravamen = :idgravamen"),
    @NamedQuery(name = "Gravamen.findByCategoria", query = "SELECT g FROM Gravamen g WHERE g.categoria = :categoria"),
    @NamedQuery(name = "Gravamen.findByAlicuota", query = "SELECT g FROM Gravamen g WHERE g.alicuota = :alicuota")})
public class Gravamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgravamen")
    private Integer idgravamen;
    @Size(max = 20)
    @Column(name = "categoria")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "alicuota")
    private Double alicuota;
    @OneToMany(mappedBy = "idgravamen")
    private Collection<Articulo> articuloCollection;

    public Gravamen() {
    }

    public Gravamen(Integer idgravamen) {
        this.idgravamen = idgravamen;
    }

    public Integer getIdgravamen() {
        return idgravamen;
    }

    public void setIdgravamen(Integer idgravamen) {
        this.idgravamen = idgravamen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(Double alicuota) {
        this.alicuota = alicuota;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgravamen != null ? idgravamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gravamen)) {
            return false;
        }
        Gravamen other = (Gravamen) object;
        if ((this.idgravamen == null && other.idgravamen != null) || (this.idgravamen != null && !this.idgravamen.equals(other.idgravamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return categoria;
    }
    
}
