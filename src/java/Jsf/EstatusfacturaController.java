package Jsf;

import Modelo.Estatusfactura;
import Jsf.util.JsfUtil;
import Jsf.util.JsfUtil.PersistAction;
import Jpa.EstatusfacturaFacade;
import Jpa.EstatusfacturaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "estatusfacturaController")
@SessionScoped
public class EstatusfacturaController implements Serializable {

    @EJB
    private EstatusfacturaFacadeLocal ejbFacade;
    private List<Estatusfactura> items = null;
    private Estatusfactura selected;

    public EstatusfacturaController() {
    }

    public Estatusfactura getSelected() {
        return selected;
    }

    public void setSelected(Estatusfactura selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EstatusfacturaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Estatusfactura prepareCreate() {
        selected = new Estatusfactura();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EstatusfacturaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EstatusfacturaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EstatusfacturaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Estatusfactura> getItems() {
        if (items == null) {
            items = getFacade().findAll();
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Estatusfactura getEstatusfactura(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Estatusfactura> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Estatusfactura> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Estatusfactura.class)
    public static class EstatusfacturaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstatusfacturaController controller = (EstatusfacturaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estatusfacturaController");
            return controller.getEstatusfactura(getKey(value));
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
            if (object instanceof Estatusfactura) {
                Estatusfactura o = (Estatusfactura) object;
                return getStringKey(o.getIdestatusfactura());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Estatusfactura.class.getName()});
                return null;
            }
        }

    }

}
