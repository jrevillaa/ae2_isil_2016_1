/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.fachadas;

import escuela.entidades.Administrador;
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

    @PersistenceContext(unitName = "s09_ejemplo01-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }

    @Override
    public String validar(String u, String p) {
        Query query = em.createNamedQuery("Administrador.validar");
        query.setParameter("u",u);
        query.setParameter("p", p);
        
        try{
            Administrador adm = (Administrador) query.getSingleResult();
            return adm.getVchAdmNombres() + " " + adm.getVchAdmApellidos();
        }catch(NoResultException ex){
              return "no encontrado";
        }
        
    }
    
    
    
}
