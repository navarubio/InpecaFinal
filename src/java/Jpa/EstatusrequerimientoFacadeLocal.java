/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Estatusrequerimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface EstatusrequerimientoFacadeLocal {

    void create(Estatusrequerimiento estatusrequerimiento);

    void edit(Estatusrequerimiento estatusrequerimiento);

    void remove(Estatusrequerimiento estatusrequerimiento);

    Estatusrequerimiento find(Object id);

    List<Estatusrequerimiento> findAll();

    List<Estatusrequerimiento> findRange(int[] range);

    int count();
    
}
