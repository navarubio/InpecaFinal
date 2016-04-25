/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Cuentabancaria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Inpeca
 */
@Local
public interface CuentabancariaFacadeLocal {

    void create(Cuentabancaria cuentabancaria);

    void edit(Cuentabancaria cuentabancaria);

    void remove(Cuentabancaria cuentabancaria);

    Cuentabancaria find(Object id);

    List<Cuentabancaria> findAll();

    List<Cuentabancaria> findRange(int[] range);

    int count();
    
    List<Cuentabancaria> espxBanco(int idbank);
    
}
