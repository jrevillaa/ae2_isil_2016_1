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
 * @author Alumno-CT
 */
public class AdministradorDao implements AdministradorService{

    @Override
    public Administrador validar(String u, String p) {
        Administrador admin = null;
        
        if(u.equalsIgnoreCase("admin") && p.equalsIgnoreCase("admin")){
            admin = new Administrador();
            admin.setNombres("Jair Edson");
            admin.setApellidos("Revilla Arroyo");
            admin.setCodigo("0");
            admin.setLogin("admin");
            admin.setPassword("admin");
        }
        
        return admin;
    }
    
}
