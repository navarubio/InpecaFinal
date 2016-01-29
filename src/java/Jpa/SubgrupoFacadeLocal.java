/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Subgrupo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface SubgrupoFacadeLocal {

    void create(Subgrupo subgrupo);

    void edit(Subgrupo subgrupo);

    void remove(Subgrupo subgrupo);

    Subgrupo find(Object id);

    List<Subgrupo> findAll();

    List<Subgrupo> findRange(int[] range);

    int count();
    
}
