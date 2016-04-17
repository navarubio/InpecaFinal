/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Subespecificocontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface SubespecificocontableFacadeLocal {

    void create(Subespecificocontable subespecificocontable);

    void edit(Subespecificocontable subespecificocontable);

    void remove(Subespecificocontable subespecificocontable);

    Subespecificocontable find(Object id);

    List<Subespecificocontable> findAll();

    List<Subespecificocontable> findRange(int[] range);

    int count();
    
    List<Subespecificocontable> subespxEspecifico(int idgrupo, int idsubg, int idespec);
}
