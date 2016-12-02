/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Pagocompra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sofimarye
 */
@Stateless
public class PagocompraFacade extends AbstractFacade<Pagocompra> implements PagocompraFacadeLocal{

    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagocompraFacade() {
        super(Pagocompra.class);
    }
    
    @Override
    public List<Pagocompra> buscarPagosefectuados() {
        String consulta;
        List<Pagocompra> lista = null;
        try {
            consulta = "SELECT p FROM Pagocompra p";
            Query query = em.createQuery(consulta);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
}
