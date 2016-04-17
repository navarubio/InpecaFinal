/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Subgrupocontable;
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
public class SubgrupocontableFacade extends AbstractFacade<Subgrupocontable> implements SubgrupocontableFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;
    
    private List<Subgrupocontable> lista = null;
    private String consulta;
    private Subgrupocontable subgrupo=null;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubgrupocontableFacade() {
        super(Subgrupocontable.class);
    }
 
    @Override
    public List<Subgrupocontable> subgxGrupo(int idgrupo) {
        try {
            consulta = "From Subgrupocontable s where s.idgrupocontable = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idgrupo);
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
