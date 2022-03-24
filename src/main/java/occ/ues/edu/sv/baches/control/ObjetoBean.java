/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import occ.ues.edu.sv.baches.entity.Objeto;

/**
 *
 * @author magdiel
 */
public class ObjetoBean extends AbstractDataAccess<Objeto> implements Serializable{
    
    @PersistenceContext (name = "bachesUP")
    EntityManager em;

    public ObjetoBean() {
        super(Objeto.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void crear(Objeto nuevo) throws IllegalArgumentException, IllegalStateException {
        super.crear(nuevo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Objeto registro) throws IllegalArgumentException, IllegalStateException {
        super.eliminar(registro); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Objeto clase) throws IllegalArgumentException, IllegalStateException {
        super.modificar(clase); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Objeto findById(Object id) throws IllegalArgumentException, IllegalStateException {
        return super.findById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypedQuery GenerarConsultaBase(EntityManager em) {
        return super.GenerarConsultaBase(em); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Objeto> findAll() throws IllegalStateException {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Objeto> findRange(int first, int pageSize) throws IllegalArgumentException,IllegalStateException {
        return super.findRange(first, pageSize); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long contar() throws IllegalStateException {
        return super.contar(); //To change body of generated methods, choose Tools | Templates.
    }
}
