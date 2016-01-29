/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Gravamen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface GravamenFacadeLocal {

    void create(Gravamen gravamen);

    void edit(Gravamen gravamen);

    void remove(Gravamen gravamen);

    Gravamen find(Object id);

    List<Gravamen> findAll();

    List<Gravamen> findRange(int[] range);

    int count();
    
}
