/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Contribuyente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface ContribuyenteFacadeLocal {

    void create(Contribuyente contribuyente);

    void edit(Contribuyente contribuyente);

    void remove(Contribuyente contribuyente);

    Contribuyente find(Object id);

    List<Contribuyente> findAll();

    List<Contribuyente> findRange(int[] range);

    int count();
    
}
