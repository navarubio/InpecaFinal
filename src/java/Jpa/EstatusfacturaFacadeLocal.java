/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Estatusfactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface EstatusfacturaFacadeLocal {

    void create(Estatusfactura estatusfactura);

    void edit(Estatusfactura estatusfactura);

    void remove(Estatusfactura estatusfactura);

    Estatusfactura find(Object id);

    List<Estatusfactura> findAll();

    List<Estatusfactura> findRange(int[] range);

    int count();
    
    Estatusfactura cambiarestatusFactura(int tipo);
    
}
