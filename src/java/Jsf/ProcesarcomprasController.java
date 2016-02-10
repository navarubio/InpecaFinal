
package Jsf;

import Modelo.Auxiliarrequerimiento;
import Modelo.Requerimiento;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped

public class ProcesarcomprasController implements Serializable{
    
    @Inject
    private ComprasController comprasController;

    private Auxiliarrequerimiento auxiliar;
    private Requerimiento reque;

    public Auxiliarrequerimiento getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Auxiliarrequerimiento auxiliar) {
        this.auxiliar = auxiliar;
    }

    public Requerimiento getReque() {
        return reque;
    }

    public void setReque(Requerimiento reque) {
        this.reque = reque;
    }
    
    @PostConstruct
    public void init(){
        this.auxiliar= comprasController.getAuxiliarrequerimiento();
        this.reque=comprasController.getRequerimiento();
    }
    
   
}
