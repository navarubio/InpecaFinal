/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Retencionpago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface RetencionpagoFacadeLocal {

    void create(Retencionpago retencionpago);

    void edit(Retencionpago retencionpago);

    void remove(Retencionpago retencionpago);

    Retencionpago find(Object id);

    List<Retencionpago> findAll();

    List<Retencionpago> findRange(int[] range);

    int count();
    
}
