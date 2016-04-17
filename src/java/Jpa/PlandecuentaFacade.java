/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Plandecuenta;
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
public class PlandecuentaFacade extends AbstractFacade<Plandecuenta> implements PlandecuentaFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;
    
    private List<Plandecuenta> lista = null;
    private String consulta;
    private Plandecuenta plandecuenta=null;


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlandecuentaFacade() {
        super(Plandecuenta.class);
    }
    
    @Override
    public List<Plandecuenta> itemsordenados () {
        try {
            consulta = "SELECT p FROM Plandecuenta p order by p.idgrupocontable,p.idsubgrupocontable,p.idespecificocontable,p.idsubespecificocontable,p.idgeneralcuenta" ;
            Query query = em.createQuery(consulta);
            
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
