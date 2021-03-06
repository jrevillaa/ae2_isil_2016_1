/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.fachada;

import ae2.entidades.Administrador;
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
public class AdministradorFacade extends AbstractFacade<Administrador> implements AdministradorFacadeLocal {

    @PersistenceContext(unitName = "s05_ejemplo1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }

    @Override
    public Administrador validar(String us, String ps) {
        Administrador vendedor; 
        Query query = em.createNamedQuery("validar");
        query.setParameter("us",us);
        query.setParameter("ps",ps);
        try{
            vendedor = (Administrador)query.getSingleResult();
        }catch (NoResultException ex){
            vendedor = null;
        }
        return vendedor;

    }
    
   
    
}
