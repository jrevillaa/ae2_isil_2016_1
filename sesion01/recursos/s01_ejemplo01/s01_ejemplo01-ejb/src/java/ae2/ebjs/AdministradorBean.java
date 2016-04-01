/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.ebjs;

import ae2.daos.AdministradorDao;
import ae2.entidades.Administrador;
import ae2.servicios.AdministradorService;
import javax.ejb.Stateless;

/**
 *
 * @author Alumno-CT
 */
@Stateless
public class AdministradorBean implements AdministradorBeanLocal {

    @Override
    public String validarLocal(String us, String ps) {
        AdministradorService dao = new AdministradorDao();
        Administrador adm = dao.validar(us,ps);
        if(adm != null){
           return adm.getNombres() + " " + adm.getApellidos();
        }
        return "no existe";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
}
