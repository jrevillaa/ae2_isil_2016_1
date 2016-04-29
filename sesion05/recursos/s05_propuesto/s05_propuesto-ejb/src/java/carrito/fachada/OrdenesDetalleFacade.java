/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.fachada;

import carrito.entidades.OrdenesDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alumno-CT
 */
@Stateless
public class OrdenesDetalleFacade extends AbstractFacade<OrdenesDetalle> implements OrdenesDetalleFacadeLocal {

    @PersistenceContext(unitName = "s05_propuesto-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenesDetalleFacade() {
        super(OrdenesDetalle.class);
    }
    
}
