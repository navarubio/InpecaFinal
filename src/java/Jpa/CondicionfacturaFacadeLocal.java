/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Condicionfactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface CondicionfacturaFacadeLocal {

    void create(Condicionfactura condicionfactura);

    void edit(Condicionfactura condicionfactura);

    void remove(Condicionfactura condicionfactura);

    Condicionfactura find(Object id);

    List<Condicionfactura> findAll();

    List<Condicionfactura> findRange(int[] range);

    int count();
    
}
