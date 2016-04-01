/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.ebjs;

import javax.ejb.Local;

/**
 *
 * @author Alumno-CT
 */
@Local
public interface AdministradorBeanLocal {

    String validarLocal(String us, String ps);
    
}
