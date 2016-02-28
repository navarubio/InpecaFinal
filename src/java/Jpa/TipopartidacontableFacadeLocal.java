/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Tipopartidacontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface TipopartidacontableFacadeLocal {

    void create(Tipopartidacontable tipopartidacontable);

    void edit(Tipopartidacontable tipopartidacontable);

    void remove(Tipopartidacontable tipopartidacontable);

    Tipopartidacontable find(Object id);

    List<Tipopartidacontable> findAll();

    List<Tipopartidacontable> findRange(int[] range);

    int count();
    
}
