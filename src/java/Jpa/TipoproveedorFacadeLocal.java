/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Tipoproveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface TipoproveedorFacadeLocal {

    void create(Tipoproveedor tipoproveedor);

    void edit(Tipoproveedor tipoproveedor);

    void remove(Tipoproveedor tipoproveedor);

    Tipoproveedor find(Object id);

    List<Tipoproveedor> findAll();

    List<Tipoproveedor> findRange(int[] range);

    int count();
    
}
