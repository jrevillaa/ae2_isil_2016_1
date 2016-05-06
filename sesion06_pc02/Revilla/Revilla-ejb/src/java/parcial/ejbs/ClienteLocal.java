/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parcial.ejbs;

import parcial.beans.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface ClienteLocal {

    Cliente validarCliente(String usuario, String password);
    
}
