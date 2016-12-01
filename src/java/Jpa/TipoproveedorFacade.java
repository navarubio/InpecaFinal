/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Tipoproveedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sofimarye
 */
@Stateless
public class TipoproveedorFacade extends AbstractFacade<Tipoproveedor> implements TipoproveedorFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoproveedorFacade() {
        super(Tipoproveedor.class);
    }
    
}
