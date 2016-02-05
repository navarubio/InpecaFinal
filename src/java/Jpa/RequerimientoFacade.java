/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Auxiliarrequerimiento;
import Modelo.Requerimiento;
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
public class RequerimientoFacade extends AbstractFacade<Requerimiento> implements RequerimientoFacadeLocal {

    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequerimientoFacade() {
        super(Requerimiento.class);
    }

    @Override
    public Auxiliarrequerimiento ultimoInsertado() {
        String consulta = null;
        Auxiliarrequerimiento ultimo = new Auxiliarrequerimiento();
        try {
            consulta = "Select a From Auxiliarrequerimiento a Order By a.idauxiliarrequerimiento Desc";        
            Query query = em.createQuery(consulta);
            List<Auxiliarrequerimiento> lista = query.getResultList();
            if (!lista.isEmpty()) {
                ultimo = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return ultimo;
    }
}
