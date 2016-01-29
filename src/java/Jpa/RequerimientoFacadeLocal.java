/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Requerimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface RequerimientoFacadeLocal {

    void create(Requerimiento requerimiento);

    void edit(Requerimiento requerimiento);

    void remove(Requerimiento requerimiento);

    Requerimiento find(Object id);

    List<Requerimiento> findAll();

    List<Requerimiento> findRange(int[] range);

    int count();
    
}
