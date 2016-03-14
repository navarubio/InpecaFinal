package Jpa;

import Modelo.Articulo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ArticuloFacade extends AbstractFacade<Articulo> implements ArticuloFacadeLocal{
    @PersistenceContext(unitName = "InpecaPU")
    private EntityManager em;
    Articulo art;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticuloFacade() {
        super(Articulo.class);
    }

    @Override
    public Articulo buscarArticulo(String codigo) {
        Articulo art=null;
        String consulta;
        try {
            consulta  = "From Articulo a where a.codigo = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codigo);

            List<Articulo> lista = query.getResultList();
            if (!lista.isEmpty()) {
                art = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return art;
    }
    
}
