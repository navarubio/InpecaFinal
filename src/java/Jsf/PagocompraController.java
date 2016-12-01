package Jsf;

import Modelo.Pagocompra;
import Jsf.util.JsfUtil;
import Jsf.util.JsfUtil.PersistAction;
import Jpa.PagocompraFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("pagocompraController")
@SessionScoped
public class PagocompraController implements Serializable {

    @EJB
    private Jpa.PagocompraFacade ejbFacade;
    private List<Pagocompra> items = null;
    private Pagocompra selected;

    public PagocompraController() {
    }

    public Pagocompra getSelected() {
        return selected;
    }

    public void setSelected(Pagocompra selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PagocompraFacade getFacade() {
        return ejbFacade;
    }

    public Pagocompra prepareCreate() {
        selected = new Pagocompra();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundlepagos").getString("PagocompraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundlepagos").getString("PagocompraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundlepagos").getString("PagocompraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Pagocompra> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundlepagos").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundlepagos").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Pagocompra getPagocompra(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Pagocompra> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Pagocompra> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Pagocompra.class)
    public static class PagocompraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PagocompraController controller = (PagocompraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pagocompraController");
            return controller.getPagocompra(getKey(value));
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
            if (object instanceof Pagocompra) {
                Pagocompra o = (Pagocompra) object;
                return getStringKey(o.getIdpagocompra());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Pagocompra.class.getName()});
                return null;
            }
        }

    }

}
