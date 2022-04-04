/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import occ.ues.edu.sv.baches.entity.TipoObjeto;

/**
 *
 * @author magdiel
 */
@Stateless
@LocalBean
@Singleton
@Startup
public class TipoObjetoBean extends AbstractDataAccess<TipoObjeto> implements Serializable{
    
    @PersistenceContext (unitName = "bachesUP")
    EntityManager em;
    
    public TipoObjetoBean (){
        super(TipoObjeto.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @PreDestroy
    public void closeEMF() {
        em.getEntityManagerFactory().close();
    }
    
}
