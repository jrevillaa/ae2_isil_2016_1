/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw2.ejbs;

import dsw2.beans.Elemento;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface CarritoLocal {

    Vector<Elemento> agregarItem(Elemento elemento);

    boolean eliminarItem(int codigo);

    Vector<Elemento> obtenerItems();

    boolean realizarPedido(int cli_codigo);
    
}
