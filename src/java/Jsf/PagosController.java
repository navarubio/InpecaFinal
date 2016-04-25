/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jsf;

import Jpa.AuxiliarrequerimientoFacadeLocal;
import Jpa.BancoFacadeLocal;
import Jpa.CompraFacadeLocal;
import Jpa.CuentabancariaFacadeLocal;
import Jpa.DepartamentoFacadeLocal;
import Jpa.DetallecompraFacadeLocal;
import Jpa.EstatusfacturaFacadeLocal;
import Jpa.PagocompraFacadeLocal;
import Jpa.RequerimientoFacadeLocal;
import Jpa.TipopagoFacadeLocal;
import Modelo.Auxiliarrequerimiento;
import Modelo.Banco;
import Modelo.Compra;
import Modelo.Cuentabancaria;
import Modelo.Departamento;
import Modelo.Detallecompra;
import Modelo.Estatusfactura;
import Modelo.Pagocompra;
import Modelo.Requerimiento;
import Modelo.Tipopago;
import Modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Inpeca
 */
@Named
@SessionScoped

public class PagosController implements Serializable {

    @EJB
    private CuentabancariaFacadeLocal cuentabancariaEJB;
    @EJB
    private PagocompraFacadeLocal pagocompraEJB;
    @EJB
    private EstatusfacturaFacadeLocal estatusfacturaEJB;
    @EJB
    private AuxiliarrequerimientoFacadeLocal auxiliarrequerimientoEJB;
    @EJB
    private CompraFacadeLocal compraEJB;
    @EJB
    private DetallecompraFacadeLocal detallecompraEJB;
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;
    @EJB
    private TipopagoFacadeLocal tipopagoEJB;
    @EJB
    private BancoFacadeLocal bancoEJB; 

    private Auxiliarrequerimiento auxiliarrequerimiento;
    private Compra compra;
    private Detallecompra detallecompras;
    private Pagocompra pagocompra= new Pagocompra();
    private Estatusfactura statusfactu = null;

    private Usuario usa;
    private Departamento dpto;
    private Compra codCompra;
    private int idAuxiliar = 0;
    private int idCompra = 0;
    private List<Auxiliarrequerimiento> auxiliarrequerimientos;
    private List<Cuentabancaria> cuentasbancarias;
    private List<Tipopago> tipopagos;
    private List<Detallecompra> detallecompraFiltrados;
    private List<Banco> bancos;
    private List<Cuentabancaria> lstCuentasSelecc;

    @Inject
    private Auxiliarrequerimiento auxiliar;
    @Inject
    private Requerimiento requerimiento;
    @Inject
    private Compra compras;
    @Inject
    private Detallecompra detallecompra;
    @Inject
    private Tipopago tipopago;
    @Inject
    private Cuentabancaria cuentabancaria;

    public List<Cuentabancaria> getLstCuentasSelecc() {
        return lstCuentasSelecc;
    }

    public void setLstCuentasSelecc(List<Cuentabancaria> lstCuentasSelecc) {
        this.lstCuentasSelecc = lstCuentasSelecc;
    }

    
    public Pagocompra getPagocompra() {
        return pagocompra;
    }

    public void setPagocompra(Pagocompra pagocompra) {
        this.pagocompra = pagocompra;
    }

    public List<Banco> getBancos() {
        return bancos;
    }

    public void setBancos(List<Banco> bancos) {
        this.bancos = bancos;
    }

    
    public Tipopago getTipopago() {
        return tipopago;
    }

    public void setTipopago(Tipopago tipopago) {
        this.tipopago = tipopago;
    }

    public List<Detallecompra> getDetallecompraFiltrados() {
        return detallecompraFiltrados;
    }

    public void setDetallecompraFiltrados(List<Detallecompra> detallecompraFiltrados) {
        this.detallecompraFiltrados = detallecompraFiltrados;
    }

    public Auxiliarrequerimiento getAuxiliarrequerimiento() {
        return auxiliarrequerimiento;
    }

    public void setAuxiliarrequerimiento(Auxiliarrequerimiento auxiliarrequerimiento) {
        this.auxiliarrequerimiento = auxiliarrequerimiento;
    }

    public int getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(int idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

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

    public List<Tipopago> getTipopagos() {
        return tipopagos;
    }

    public void setTipopagos(List<Tipopago> tipopagos) {
        this.tipopagos = tipopagos;
    }

    @PostConstruct
    public void init() {
        auxiliarrequerimientos = auxiliarrequerimientoEJB.findAll();
        cuentasbancarias = cuentabancariaEJB.findAll();
        tipopagos = tipopagoEJB.findAll();
        bancos = bancoEJB.findAll();
        //articulos = articuloEJB.findAll();
        //comprasporautorizar=compraEJB.buscarcomprasporAutorizar();

//        this.auxiliarrequerimiento=requerimientosController.getAuxrequer();
    }

    public void asignar(Compra compr) {
        this.compra = compr;
        this.idCompra = compr.getIdcompra();
        this.auxiliarrequerimiento = compr.getIdauxiliarrequerimiento();
//        this.auxiliar = aux;
        detallecompraFiltrados = detallecompraAuxiliar();
//        this.compra.setIdauxiliarrequerimiento(auxiliar);
    }

    public List<Detallecompra> detallecompraAuxiliar() {
        List<Detallecompra> listado = null;
        listado = detallecompraEJB.buscardetallecompra(compra);
        return listado;
    }

    public List<Requerimiento> requerimientosAuxiliar() {
        List<Requerimiento> listado = null;
        //**** listado = requerimientoEJB.requerimientosAuxiliar(idAuxiliar);
        return listado;
    }

    public Usuario getUsuario() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        usa = us;
        return us;
    }

    public Departamento buscarDepartamento() {
        Usuario usua = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        dpto = departamentoEJB.buscarDepartamento(usua);
//        statusreq.setIdestatusrequerimiento(statu);
        return dpto;
    }
    
    public List<Cuentabancaria> refrescarCuentasBancarias() {
        try {
            lstCuentasSelecc = cuentabancariaEJB.espxBanco(pagocompra.getIdbanco().getIdbanco());
        } catch (Exception e) {
        }
        return lstCuentasSelecc;
    }
        public void registrar() {        
        try {
/**            compra.setRifproveedor(provee);
            compra.setSubtotal(auxiliar.getSubtotal());
            compra.setIva(auxiliar.getMontoiva());
            compra.setTotal(auxiliar.getMontototal());
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            compra.setIdusuario(us);**/            
            int tipo=3;
            statusfactu= estatusfacturaEJB.cambiarestatusFactura(tipo);
            compra.setIdestatusfactura(statusfactu);
            compraEJB.edit(compra);                     
            //codCompra = compraEJB.ultimacompraInsertada();
            
            pagocompra.setIdcompra(compra);
            pagocompra.setTotalpago(compra.getTotal());
            pagocompraEJB.create(pagocompra);            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Su Pago fue Almacenado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al Grabar Pago"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
}
