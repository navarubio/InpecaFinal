/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Subgrupocontable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface SubgrupocontableFacadeLocal {

    void create(Subgrupocontable subgrupocontable);

    void edit(Subgrupocontable subgrupocontable);

    void remove(Subgrupocontable subgrupocontable);

    Subgrupocontable find(Object id);

    List<Subgrupocontable> findAll();

    List<Subgrupocontable> findRange(int[] range);
    
    List<Subgrupocontable> subgxGrupo(int idgrupo);

    int count();
    
}
