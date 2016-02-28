/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Detallecompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface DetallecompraFacadeLocal {

    void create(Detallecompra detallecompra);

    void edit(Detallecompra detallecompra);

    void remove(Detallecompra detallecompra);

    Detallecompra find(Object id);

    List<Detallecompra> findAll();

    List<Detallecompra> findRange(int[] range);

    int count();
    
}
