/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.fachada;

import carrito.entidades.OrdenesDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno-CT
 */
@Local
public interface OrdenesDetalleFacadeLocal {

    void create(OrdenesDetalle ordenesDetalle);

    void edit(OrdenesDetalle ordenesDetalle);

    void remove(OrdenesDetalle ordenesDetalle);

    OrdenesDetalle find(Object id);

    List<OrdenesDetalle> findAll();

    List<OrdenesDetalle> findRange(int[] range);

    int count();
    
}
