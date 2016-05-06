/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parcial.ejbs;

import parcial.beans.Producto;
import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface ProductoLocal {

    java.util.Vector<Producto> obtenerListaProductos();

    Producto buscarProducto(int codigo);
    
}
