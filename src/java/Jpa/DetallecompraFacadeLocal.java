package Jpa;

import Modelo.Compra;
import Modelo.Detallecompra;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DetallecompraFacadeLocal {

    void create(Detallecompra detallecompra);

    void edit(Detallecompra detallecompra);

    void remove(Detallecompra detallecompra);

    Detallecompra find(Object id);

    List<Detallecompra> findAll();

    List<Detallecompra> findRange(int[] range);

    int count();
    
    Detallecompra ultimodetalleInsertado ();
    
    List<Detallecompra> buscardetallecompra (Compra compra);
}
