/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Subespecificocontable;
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
public class SubespecificocontableFacade extends AbstractFacade<Subespecificocontable> implements SubespecificocontableFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;
    
    private List<Subespecificocontable> lista = null;
    private String consulta;
    private Subespecificocontable subespecifico=null;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubespecificocontableFacade() {
        super(Subespecificocontable.class);
    }
    
    @Override
    public List<Subespecificocontable> subespxEspecifico(int idgrupo, int idsubg, int idespec) {
        try {
            consulta = "From Subespecificocontable s where s.idgrupocontable = ?1 and  s.idsubgrupocontable= ?2 and  s.idespecificocontable= ?3";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idgrupo);
            query.setParameter(2, idsubg);
            query.setParameter(3, idespec);
            
            lista = query.getResultList();
//            if (!lista.isEmpty()) {
//                usuario = lista.get(0);
//            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
}
