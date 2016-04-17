/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Especificocontable;
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
public class EspecificocontableFacade extends AbstractFacade<Especificocontable> implements EspecificocontableFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;
    
    private List<Especificocontable> lista = null;
    private String consulta;
    private Especificocontable especifico=null;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecificocontableFacade() {
        super(Especificocontable.class);
    }
    
    @Override
    public List<Especificocontable> espxSGrupo(int idgrupo, int idsubg) {
        try {
            consulta = "From Especificocontable e where e.idgrupocontable = ?1 and  e.idsubgrupocontable= ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idgrupo);
            query.setParameter(2, idsubg);
            
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
