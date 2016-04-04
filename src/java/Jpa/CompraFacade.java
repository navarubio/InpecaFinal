/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Compra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
/**
 *
 * @author Inpeca
 */
@Stateless
public class CompraFacade extends AbstractFacade<Compra> implements CompraFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraFacade() {
        super(Compra.class);
    }

    @Override
    public Compra ultimacompraInsertada() {
        String consulta = null;
        Compra ultimo = new Compra();
        try {
            consulta = "Select c From Compra c Order By c.idcompra Desc";
            Query query = em.createQuery(consulta);
            List<Compra> lista = query.getResultList();
            if (!lista.isEmpty()) {
                ultimo = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return ultimo;
    }
    @Override
    public List<Compra> buscarcomprasporAutorizar() {
        String consulta;
        int idstatus = 1;
        List<Compra> lista = null;
        try {
            consulta = "From Compra c where c.idestatusfactura.idestatusfactura= ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idstatus);
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
