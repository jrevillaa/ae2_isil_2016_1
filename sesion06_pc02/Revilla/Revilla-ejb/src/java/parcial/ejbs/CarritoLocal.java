/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parcial.ejbs;

import parcial.beans.Elemento;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface CarritoLocal {

    Vector<Elemento> agregarItem(Elemento elemento);

    boolean eliminarItem(String codigo);

    Vector<Elemento> obtenerItems();

    boolean realizarPedido(String cli_codigo);
    
}
