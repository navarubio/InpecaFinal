/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import Modelo.Departamento;
import Modelo.Usuario;
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
public class DepartamentoFacade extends AbstractFacade<Departamento> implements DepartamentoFacadeLocal{

    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
    @Override
    public Departamento buscarDepartamento (Usuario us) {
        Departamento dpto=null;
        String consulta;
        try {
            consulta  = "From Departamento d where d.iddepartamento = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getIddepartamento().getIddepartamento());

            List<Departamento> lista = query.getResultList();
            if (!lista.isEmpty()) {
                dpto = lista.get(0);
}
        } catch (Exception e) {
            throw e;
        }
        return dpto;
    }
}
