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
import occ.ues.edu.sv.baches.entity.Estado;

/**
 *
 * @author magdiel
 */
public class EstadoBean extends AbstractDataAccess<Estado>implements Serializable{

    @PersistenceContext (name = "bachesUP")
    EntityManager em;
    
    public EstadoBean() {
        super(Estado.class);
    }
    
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void crear(Estado nuevo) throws IllegalArgumentException, IllegalStateException {
        super.crear(nuevo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object id) throws IllegalArgumentException, IllegalStateException {
        super.eliminar(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Estado clase) throws IllegalArgumentException, IllegalStateException {
        super.modificar(clase); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado findById(Object id) throws IllegalArgumentException, IllegalStateException {
        return super.findById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estado> findAll() throws IllegalStateException {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estado> findRange(int first, int pageSize) throws IllegalStateException {
        return super.findRange(first, pageSize); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long contar() throws IllegalStateException {
        return super.contar(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
