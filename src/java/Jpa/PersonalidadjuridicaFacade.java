/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Personalidadjuridica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sofimarye
 */
@Stateless
public class PersonalidadjuridicaFacade extends AbstractFacade<Personalidadjuridica> implements PersonalidadjuridicaFacadeLocal{

    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalidadjuridicaFacade() {
        super(Personalidadjuridica.class);
    }
    
}
