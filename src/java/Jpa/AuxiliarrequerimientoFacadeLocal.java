/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Auxiliarrequerimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface AuxiliarrequerimientoFacadeLocal {

    void create(Auxiliarrequerimiento auxiliarrequerimiento);

    void edit(Auxiliarrequerimiento auxiliarrequerimiento);

    void remove(Auxiliarrequerimiento auxiliarrequerimiento);

    Auxiliarrequerimiento find(Object id);

    List<Auxiliarrequerimiento> findAll();

    List<Auxiliarrequerimiento> findRange(int[] range);

    int count();
    
}
