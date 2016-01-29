/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Deposito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface DepositoFacadeLocal {

    void create(Deposito deposito);

    void edit(Deposito deposito);

    void remove(Deposito deposito);

    Deposito find(Object id);

    List<Deposito> findAll();

    List<Deposito> findRange(int[] range);

    int count();
    
}
