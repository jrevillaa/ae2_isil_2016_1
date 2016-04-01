/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.ejbs;

import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface EmpleadoBeanLocal {

	String validar(String usuario, String password);
	
}
