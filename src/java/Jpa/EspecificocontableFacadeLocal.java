/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Especificocontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface EspecificocontableFacadeLocal {

    void create(Especificocontable especificocontable);

    void edit(Especificocontable especificocontable);

    void remove(Especificocontable especificocontable);

    Especificocontable find(Object id);

    List<Especificocontable> findAll();

    List<Especificocontable> findRange(int[] range);

    int count();

    List<Especificocontable> espxSGrupo(int idgrupo, int idsubg);
}
