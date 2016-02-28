/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Tipocuentacontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface TipocuentacontableFacadeLocal {

    void create(Tipocuentacontable tipocuentacontable);

    void edit(Tipocuentacontable tipocuentacontable);

    void remove(Tipocuentacontable tipocuentacontable);

    Tipocuentacontable find(Object id);

    List<Tipocuentacontable> findAll();

    List<Tipocuentacontable> findRange(int[] range);

    int count();
    
}
