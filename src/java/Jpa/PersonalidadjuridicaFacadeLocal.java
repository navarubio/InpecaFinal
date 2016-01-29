/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Personalidadjuridica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface PersonalidadjuridicaFacadeLocal {

    void create(Personalidadjuridica personalidadjuridica);

    void edit(Personalidadjuridica personalidadjuridica);

    void remove(Personalidadjuridica personalidadjuridica);

    Personalidadjuridica find(Object id);

    List<Personalidadjuridica> findAll();

    List<Personalidadjuridica> findRange(int[] range);

    int count();
    
}
