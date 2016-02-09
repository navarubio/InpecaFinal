
package Jsf;

import Jpa.ArticuloFacadeLocal;
import Jpa.AuxiliarrequerimientoFacadeLocal;
import Jpa.ProveedorFacadeLocal;
import Jpa.RequerimientoFacadeLocal;
import Modelo.Articulo;
import Modelo.Auxiliarrequerimiento;
import Modelo.Proveedor;
import Modelo.Requerimiento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
    
public class ComprasController implements Serializable{
    @EJB 
    private AuxiliarrequerimientoFacadeLocal auxiliarrequerimientoEJB;
    @EJB
    private RequerimientoFacadeLocal requerimientoEJB;
    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    @EJB
    private ArticuloFacadeLocal articuloEJB;
    
    private Auxiliarrequerimiento auxiliarrequerimiento;
    private Requerimiento requerimiento;
    
    
    private List<Auxiliarrequerimiento> auxiliarrequerimientos;
    private List<Requerimiento> requerimientos;
    private List<Proveedor> proveedores;
    private List<Articulo> articulos;
  
    public List<Auxiliarrequerimiento> getAuxiliarrequerimientos() {
        return auxiliarrequerimientos;
    }

    public void setAuxiliarrequerimientos(List<Auxiliarrequerimiento> auxiliarrequerimientos) {
        this.auxiliarrequerimientos = auxiliarrequerimientos;
    }

    public List<Requerimiento> getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(List<Requerimiento> requerimientos) {
        this.requerimientos = requerimientos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public Auxiliarrequerimiento getAuxiliarrequerimiento() {
        return auxiliarrequerimiento;
    }

    public void setAuxiliarrequerimiento(Auxiliarrequerimiento auxiliarrequerimiento) {
        this.auxiliarrequerimiento = auxiliarrequerimiento;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }
    
    
    @PostConstruct
    public void init (){
        auxiliarrequerimientos=auxiliarrequerimientoEJB.findAll();
        requerimientos=requerimientoEJB.findAll();
        proveedores=proveedorEJB.findAll();
        articulos=articuloEJB.findAll();
    }

    public void asignar(Auxiliarrequerimiento aux, Requerimiento requeri){
        this.auxiliarrequerimiento = aux;
        this.requerimiento=requeri;
    }
    
    public List<Requerimiento> buscarRequerimiento (Auxiliarrequerimiento auxiliarrequerimiento){
        List<Requerimiento> listado = null;
        listado = requerimientoEJB.buscarRequerimientos(auxiliarrequerimiento);
        return listado;
    }
}
