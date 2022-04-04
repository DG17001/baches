/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
