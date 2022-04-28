/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import occ.ues.edu.sv.baches.entity.Objeto;

/**
 *
 * @author magdiel
 */
@Stateless
@LocalBean
public class ObjetoBean extends AbstractDataAccess<Objeto> implements Serializable{
    
    @PersistenceContext (unitName = "bachesUP")
    EntityManager em;

    public ObjetoBean() {
        super(Objeto.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<Objeto> findByIdTipoObjeto(final Integer idTipoObjeto, int frist, int pageSize) {
        if (this.em != null && idTipoObjeto != null) {
            Query q = em.createNamedQuery("Objeto.findByTipoObjeto");
            q.setParameter("idTipoObjeto", idTipoObjeto);
            q.setFirstResult(frist);
            q.setMaxResults(pageSize);
            return q.getResultList();
        }
        return Collections.EMPTY_LIST;

    }
    
    public int countTipoObjeto(final Integer idTipoObjeto) {
        if (this.em != null && idTipoObjeto != null) {
            Query q = em.createNamedQuery("Objeto.countByTipoObjeto");
            q.setParameter("idTipoObjeto", idTipoObjeto);
            
            return ((Long) q.getSingleResult()).intValue(); 
        }
        return 0;
    }
    
    public List<Objeto> findName(final String name){
        Query q=em.createNamedQuery("Objeto.findName");
        q.setParameter("nombre", name);
        return q.getResultList();
        
    }
}
