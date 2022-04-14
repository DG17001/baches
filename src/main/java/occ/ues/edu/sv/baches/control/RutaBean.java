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
import occ.ues.edu.sv.baches.entity.Ruta;

/**
 *
 * @author magdiel
 */
@Stateless
@LocalBean
public class RutaBean extends AbstractDataAccess<Ruta> implements Serializable{
    
    @PersistenceContext (unitName = "bachesUP")
    EntityManager em;
    
    public RutaBean (){
        super(Ruta.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void crear(Ruta nuevo) throws IllegalArgumentException, IllegalStateException {
        super.crear(nuevo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Ruta registro) throws IllegalArgumentException, IllegalStateException {
        super.eliminar(registro); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Ruta clase) throws IllegalArgumentException, IllegalStateException {
        super.modificar(clase); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ruta findById(Object id) throws IllegalArgumentException, IllegalStateException {
        return super.findById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ruta> findAll() throws IllegalStateException {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ruta> findRange(int first, int pageSize) throws IllegalArgumentException,IllegalStateException {
        return super.findRange(first, pageSize); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypedQuery GenerarConsultaBase(EntityManager em) {
        return super.GenerarConsultaBase(em); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long contar() throws IllegalStateException {
        return super.contar(); //To change body of generated methods, choose Tools | Templates.
    }
}
