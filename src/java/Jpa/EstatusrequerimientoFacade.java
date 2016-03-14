/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Estatusrequerimiento;
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
public class EstatusrequerimientoFacade extends AbstractFacade<Estatusrequerimiento> implements EstatusrequerimientoFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstatusrequerimientoFacade() {
        super(Estatusrequerimiento.class);
    }
    
    @Override
    public Estatusrequerimiento cambiarestatusaProcesado() {
        String consulta;
        int idstatus=2;
        Estatusrequerimiento estatus = new Estatusrequerimiento();
        try {
            consulta = "From Estatusrequerimiento e where e.idestatusrequerimiento= ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idstatus);
            List<Estatusrequerimiento> lista = query.getResultList();
            if (!lista.isEmpty()) {
                estatus = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return estatus;
    }
}
