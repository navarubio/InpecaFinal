package Jsf;

import Jpa.ArticuloFacadeLocal;
import Jpa.AuxiliarrequerimientoFacadeLocal;
import Jpa.CompraFacadeLocal;
import Jpa.ProveedorFacadeLocal;
import Jpa.RequerimientoFacadeLocal;
import Modelo.Articulo;
import Modelo.Auxiliarrequerimiento;
import Modelo.Detallecompra;
import Modelo.Compra;
import Modelo.Proveedor;
import Modelo.Requerimiento;
import Modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped

public class ComprasController implements Serializable {

    @EJB
    private AuxiliarrequerimientoFacadeLocal auxiliarrequerimientoEJB;
    @EJB
    private RequerimientoFacadeLocal requerimientoEJB;
    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    @EJB
    private ArticuloFacadeLocal articuloEJB;
    @EJB
    private CompraFacadeLocal compraEJB;

    private Auxiliarrequerimiento auxiliarrequerimiento;

    @Inject
    private Auxiliarrequerimiento auxiliar;

    @Inject
    private Requerimiento requerimiento;

    @Inject
    private Compra compra;
    @Inject
    private Detallecompra detallecompra;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Detallecompra getDetallecompra() {
        return detallecompra;
    }

    public void setDetallecompra(Detallecompra detallecompra) {
        this.detallecompra = detallecompra;
    }

    private List<Auxiliarrequerimiento> auxiliarrequerimientos;
    private List<Requerimiento> requerimientos;
    private List<Proveedor> proveedores;
    private List<Articulo> articulos;
    private int idAuxiliar = 0;
    private List<Requerimiento> requerimientosFiltrados;
    private List<Detallecompra> detallesCompras;
    

    public int getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(int idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    @Inject
    private Proveedor provee;

    @Inject
    private RequerimientosController requerimientosController;

    public Proveedor getProvee() {
        return provee;
    }

    public void setProvee(Proveedor provee) {
        this.provee = provee;
    }

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

    public List<Requerimiento> getRequerimientosFiltrados() {
        return requerimientosFiltrados;
    }

    public void setRequerimientosFiltrados(List<Requerimiento> requerimientosFiltrados) {
        this.requerimientosFiltrados = requerimientosFiltrados;
    }

    public List<Detallecompra> getDetallesCompras() {
        return detallesCompras;
    }

    public void setDetallesCompras(List<Detallecompra> detallesCompras) {
        this.detallesCompras = detallesCompras;
    }

    @PostConstruct
    public void init() {
        auxiliarrequerimientos = auxiliarrequerimientoEJB.findAll();
        requerimientos = requerimientoEJB.findAll();
        proveedores = proveedorEJB.findAll();
        articulos = articuloEJB.findAll();
//        this.auxiliarrequerimiento=requerimientosController.getAuxrequer();

    }

    public void asignar(Auxiliarrequerimiento aux) {
        this.auxiliarrequerimiento = aux;
        this.idAuxiliar = aux.getIdauxiliarrequerimiento();
        this.auxiliar = aux;
        this.requerimientosFiltrados = requerimientosController.buscarRequerimiento(aux);
        this.compra.setIdauxiliarrequerimiento(auxiliar);
    }

    public List<Requerimiento> buscarrequerimiento() {
        List<Requerimiento> listado = null;
        listado = requerimientoEJB.buscarrequerimientos(auxiliarrequerimiento);
        return listado;
    }

    public List<Requerimiento> requerimientosAuxiliar() {
        List<Requerimiento> listado = null;
        listado = requerimientoEJB.requerimientosAuxiliar(auxiliarrequerimiento.getIdauxiliarrequerimiento());
        return listado;
    }

    public void asignarProveedor(Proveedor proveed) {
        provee = proveed;
    }

    public void modificar() {
        double subtotal = 0;
        double alicuota = 0;
        double iva = 0;
        double total = 0;
        subtotal = requerimiento.getCantidad() * requerimiento.getPcosto();
        alicuota = requerimiento.getCodigo().getIdgravamen().getAlicuota();
        iva = (subtotal * alicuota)/100;
        total = subtotal + iva;
        requerimiento.setSubtotal(subtotal);
        requerimiento.setTributoiva(iva);
        requerimiento.setTotal(total);
        
        requerimientoEJB.edit(requerimiento);
  
/*        for (Detallecompra dc : requerimientosFiltrados) {
                Articulo arti = rq.getCodigo();
                requer.setIdauxiliarrequerimiento(codAux);
                requer.setCodigo(arti);
                requer.setCantidad(rq.getCantidad());
                requer.setPcosto(rq.getPcosto());
                requer.setSubtotal(rq.getSubtotal());
                requer.setTributoiva(rq.getTributoiva());
                requer.setTotal(rq.getTotal());
                requerimientoEJB.create(requer);
            }

        double totaltotal;
        double montotgeneral = 0;
        double montotiva = 0;
        double montotsubtotal = 0;

        for (Requerimiento requeri : listarequerimiento) {
            montotgeneral += requeri.getTotal();
            montotiva += requeri.getTributoiva();
            montotsubtotal += requeri.getSubtotal();
        }*/
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Su Requerimiento fue Modificado"));
    }

    public void asignarRequerimiento(Requerimiento requeri) {
        requerimiento = requeri;
    }

    public List<Requerimiento> solicitarRequerimientosFiltro() {
        return requerimientosFiltrados;
    }

    public void actualizarRequerimiento() {
        double subtotal = 0;
        double alicuota = 0;
        double iva = 0;
        double total = 0;
        subtotal = requerimiento.getCantidad() * requerimiento.getPcosto();
        alicuota = requerimiento.getCodigo().getIdgravamen().getAlicuota();
        iva = subtotal * alicuota;
        total = subtotal + iva;
        requerimiento.setSubtotal(subtotal);
        requerimiento.setTributoiva(iva);
        requerimiento.setTotal(total);
    }

    public void registrar() {
        try {
            compra.setRifproveedor(provee);
            compra.setSubtotal(auxiliar.getSubtotal());
            compra.setIva(auxiliar.getMontoiva());
            compra.setTotal(auxiliar.getMontototal());
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            compra.setIdusuario(us);

            compraEJB.create(compra);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Su Requerimiento fue Almacenado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Grabar Requerimiento"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

}
