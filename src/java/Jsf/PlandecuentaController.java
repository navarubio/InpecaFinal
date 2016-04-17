package Jsf;

import Modelo.Plandecuenta;
import Jsf.util.JsfUtil;
import Jsf.util.JsfUtil.PersistAction;
import Jpa.PlandecuentaFacade;
import Jpa.PlandecuentaFacadeLocal;
import Modelo.Especificocontable;
import Modelo.Grupocontable;
import Modelo.Subespecificocontable;
import Modelo.Subgrupocontable;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("plandecuentaController")
@SessionScoped
public class PlandecuentaController implements Serializable {

    @EJB
    private Jpa.PlandecuentaFacadeLocal ejbFacade;
    @EJB
    private Jpa.GrupocontableFacadeLocal ejbFacadeG;
    @EJB
    private Jpa.SubgrupocontableFacadeLocal ejbFacadeSG;
    @EJB
    private Jpa.EspecificocontableFacadeLocal ejbFacadeES;
    @EJB
    private Jpa.SubespecificocontableFacadeLocal ejbFacadeSE;

    private List<Plandecuenta> items = null;
    private Plandecuenta selected;

    private List<Grupocontable> lstGrupos;
    private List<Subgrupocontable> lstSubgrupos;
    private List<Especificocontable> lstEspecificos;
    private List<Subespecificocontable> lstSubespecificos;

    public List<Grupocontable> getLstGrupos() {
        return lstGrupos;
    }

    public void setLstGrupos(List<Grupocontable> lstGrupos) {
        this.lstGrupos = lstGrupos;
    }

    @PostConstruct
    public void init() {
        lstGrupos = ejbFacadeG.findAll();
    }

    public List<Subgrupocontable> getLstSubgrupos() {
        return lstSubgrupos;
    }

    public void setLstSubgrupos(List<Subgrupocontable> lstSubgrupos) {
        this.lstSubgrupos = lstSubgrupos;
    }

    public List<Especificocontable> getLstEspecificos() {
        return lstEspecificos;
    }

    public void setLstEspecificos(List<Especificocontable> lstEspecificos) {
        this.lstEspecificos = lstEspecificos;
    }

    public List<Subespecificocontable> getLstSubespecificos() {
        return lstSubespecificos;
    }

    public void setLstSubespecificos(List<Subespecificocontable> lstSubespecificos) {
        this.lstSubespecificos = lstSubespecificos;
    }

    public PlandecuentaController() {
    }

    public Plandecuenta getSelected() {
        return selected;
    }

    public void setSelected(Plandecuenta selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PlandecuentaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Plandecuenta prepareCreate() {
        selected = new Plandecuenta();
        initializeEmbeddableKey();
        return selected;
    }

    public List<Subgrupocontable> refrescarSubgrupos() {
        try {
            lstSubgrupos = ejbFacadeSG.subgxGrupo(selected.getIdgrupocontable());
        } catch (Exception e) {
        }
        return lstSubgrupos;
    }

    public List<Especificocontable> refrescarEspecificos() {
        try {
            lstEspecificos = ejbFacadeES.espxSGrupo(selected.getIdgrupocontable(), selected.getIdsubgrupocontable());
        } catch (Exception e) {
        }
        return lstEspecificos;
    }

    public List<Subespecificocontable> refrescarSubespecificos() {
        try {
            lstSubespecificos = ejbFacadeSE.subespxEspecifico(selected.getIdgrupocontable(), selected.getIdsubgrupocontable(), selected.getIdespecificocontable());
        } catch (Exception e) {
        }
        return lstSubespecificos;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundlecontable").getString("PlandecuentaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundlecontable").getString("PlandecuentaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundlecontable").getString("PlandecuentaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Plandecuenta> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<Plandecuenta> getItemsordenados() {
        if (items == null) {
            items = getFacade().itemsordenados();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundlecontable").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundlecontable").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Plandecuenta getPlandecuenta(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Plandecuenta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Plandecuenta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Plandecuenta.class)
    public static class PlandecuentaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlandecuentaController controller = (PlandecuentaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "plandecuentaController");
            return controller.getPlandecuenta(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Plandecuenta) {
                Plandecuenta o = (Plandecuenta) object;
                return getStringKey(o.getIdplandecuenta());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Plandecuenta.class.getName()});
                return null;
            }
        }

    }

}
