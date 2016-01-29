/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Articulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface ArticuloFacadeLocal {

    void create(Articulo articulo);

    void edit(Articulo articulo);

    void remove(Articulo articulo);

    Articulo find(Object id);

    List<Articulo> findAll();

    List<Articulo> findRange(int[] range);

    int count();
    
}
