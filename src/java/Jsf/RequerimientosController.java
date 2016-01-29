package Jsf;

import Jpa.ArticuloFacadeLocal;
import Jpa.AuxiliarrequerimientoFacadeLocal;
import Jpa.DepartamentoFacadeLocal;
import Jpa.RequerimientoFacadeLocal;
import Modelo.Articulo;
import Modelo.Auxiliarrequerimiento;
import Modelo.Departamento;
import Modelo.Requerimiento;
import Modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped

public class RequerimientosController implements Serializable {

    @EJB
    private ArticuloFacadeLocal articuloEJB;
    @EJB
    private RequerimientoFacadeLocal RequerimientoEJB;
    @EJB
    private AuxiliarrequerimientoFacadeLocal AuxiliarrequerimientoEJB;
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;

    @PostConstruct
    public void init() {
        articulos = articuloEJB.findAll();
    }
    private List<Articulo> articulos = null;

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Inject
    private Articulo articulo;
    @Inject
    private Requerimiento requer;
    @Inject
    private Auxiliarrequerimiento auxrequer;
    @Inject
    private Usuario usa;
    @Inject
    private Departamento dpto;

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Requerimiento getRequer() {
        return requer;
    }

    public void setRequer(Requerimiento requer) {
        this.requer = requer;
    }

    public Auxiliarrequerimiento getAuxrequer() {
        return auxrequer;
    }

    public void setAuxrequer(Auxiliarrequerimiento auxrequer) {
        this.auxrequer = auxrequer;
    }
    
    public Usuario getUsuario(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us;
    } 
    
    public Departamento buscarDepartamento (){
        Usuario usua = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        dpto = departamentoEJB.buscarDepartamento(usua);
        return dpto;        
    }
}
