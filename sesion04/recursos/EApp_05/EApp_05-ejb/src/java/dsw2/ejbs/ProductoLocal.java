/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw2.ejbs;

import dsw2.beans.Producto;
import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface ProductoLocal {

    java.util.Vector<Producto> agregarProducto(Producto producto);

    java.util.Vector<Producto> obtenerProductos();

    boolean hacerPedido();

    boolean eliminarProducto(int codigo);
    
}
