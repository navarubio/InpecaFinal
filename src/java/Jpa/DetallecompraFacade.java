/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Auxiliarrequerimiento;
import Modelo.Compra;
import Modelo.Detallecompra;
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
public class DetallecompraFacade extends AbstractFacade<Detallecompra> implements DetallecompraFacadeLocal{

    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallecompraFacade() {
        super(Detallecompra.class);
    }

    @Override
    public Detallecompra ultimodetalleInsertado() {
        String consulta = null;
        Detallecompra ultimo = new Detallecompra();
        try {
            consulta = "Select a From Auxiliarrequerimiento a Order By a.idauxiliarrequerimiento Desc";
            Query query = em.createQuery(consulta);
            List<Detallecompra> lista = query.getResultList();
            if (!lista.isEmpty()) {
                ultimo = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return ultimo;
    }

    @Override
    public List<Detallecompra> buscardetallecompra(Compra compra) {
        String consulta;
        List<Detallecompra> lista = null;
        try {
            consulta = "From Detallecompra d where d.idcompra.idcompra = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, compra.getIdcompra());
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
