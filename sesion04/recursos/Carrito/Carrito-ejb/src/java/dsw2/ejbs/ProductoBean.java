/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw2.ejbs;

import dsw2.beans.Producto;
import dsw2.daos.ProductoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Profesor
 */
@Stateless
public class ProductoBean implements ProductoLocal {

    public java.util.Vector<Producto> obtenerListaProductos() {
        try {
            return new ProductoDAO().obtenerProductos();
        } catch (SQLException ex) {
            return  null;
        }
    }

    public Producto buscarProducto(int codigo) {
        try {
            return new ProductoDAO().obtenerProducto(codigo);
        } catch (SQLException ex) {
            return null;
        }
    }
    




}
