/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Tiposaldocontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface TiposaldocontableFacadeLocal {

    void create(Tiposaldocontable tiposaldocontable);

    void edit(Tiposaldocontable tiposaldocontable);

    void remove(Tiposaldocontable tiposaldocontable);

    Tiposaldocontable find(Object id);

    List<Tiposaldocontable> findAll();

    List<Tiposaldocontable> findRange(int[] range);

    int count();
    
}
