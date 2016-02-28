/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Estatuscontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface EstatuscontableFacadeLocal {

    void create(Estatuscontable estatuscontable);

    void edit(Estatuscontable estatuscontable);

    void remove(Estatuscontable estatuscontable);

    Estatuscontable find(Object id);

    List<Estatuscontable> findAll();

    List<Estatuscontable> findRange(int[] range);

    int count();
    
}
