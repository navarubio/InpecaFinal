/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Grupocontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface GrupocontableFacadeLocal {

    void create(Grupocontable grupocontable);

    void edit(Grupocontable grupocontable);

    void remove(Grupocontable grupocontable);

    Grupocontable find(Object id);

    List<Grupocontable> findAll();

    List<Grupocontable> findRange(int[] range);

    int count();
    
}
