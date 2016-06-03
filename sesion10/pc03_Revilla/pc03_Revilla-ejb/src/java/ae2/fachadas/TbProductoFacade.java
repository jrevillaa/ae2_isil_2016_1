/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.fachadas;

import ae2.entidades.TbProducto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alumno-CT
 */
@Stateless
public class TbProductoFacade extends AbstractFacade<TbProducto> implements TbProductoFacadeLocal {

    @PersistenceContext(unitName = "pc03_Revilla-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbProductoFacade() {
        super(TbProducto.class);
    }

    @Override
    public List<TbProducto> prodPerRange(int min, int max) {
        List<TbProducto> lst = new ArrayList<>();
        Query query = em.createNamedQuery("TbProducto.rango");
        query.setParameter("stmin",min);
        query.setParameter("stmax", max);
        
        try{
            lst  = (List<TbProducto>) query.getResultList();
            return lst;
        }catch(NoResultException ex){
              return lst;
        }
    }

    @Override
    public List<TbProducto> findAllOrder() {
        List<TbProducto> lst = new ArrayList<>();
        Query query = em.createNamedQuery("TbProducto.buscar");
        
        try{
            lst  = (List<TbProducto>) query.getResultList();
            return lst;
        }catch(NoResultException ex){
              return lst;
        }
    }

    @Override
    public List<TbProducto> findByName(String name) {
        //query.setParameter("nomb","%" + name + "%");
        List<TbProducto> lst = new ArrayList<>();
        Query query = em.createNamedQuery("TbProducto.nombre");
        query.setParameter("nomb","%" + name + "%");
        
        try{
            lst  = (List<TbProducto>) query.getResultList();
            return lst;
        }catch(NoResultException ex){
              return lst;
        }
    }
    
    

    
    
    
}
