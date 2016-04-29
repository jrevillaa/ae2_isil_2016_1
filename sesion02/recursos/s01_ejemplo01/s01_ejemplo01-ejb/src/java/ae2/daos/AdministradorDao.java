/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.daos;

import ae2.entidades.Administrador;
import ae2.servicios.AdministradorService;

/**
 *
 * @author Profesor
 */
public class AdministradorDao implements AdministradorService{

    @Override
    public Administrador validar(String u, String p) {
        Administrador administrador= null;
        if(u.equalsIgnoreCase("admin")&&p.equalsIgnoreCase("admin")){
            administrador = new Administrador();
            administrador.setNombres("juan");
            administrador.setApellidos("perez");
        }
        return administrador;
    }
    
}
