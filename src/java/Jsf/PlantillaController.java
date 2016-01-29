
package Jsf;

import Modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class PlantillaController implements Serializable {
    
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            
            if (us == null){
                context.getExternalContext().redirect("../permisos.xhtml");
            }
        } catch (Exception e) {
        }
        
    }
    
    public void cerrarSesion (){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }    
}
