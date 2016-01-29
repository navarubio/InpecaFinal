/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Medida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface MedidaFacadeLocal {

    void create(Medida medida);

    void edit(Medida medida);

    void remove(Medida medida);

    Medida find(Object id);

    List<Medida> findAll();

    List<Medida> findRange(int[] range);

    int count();
    
}
