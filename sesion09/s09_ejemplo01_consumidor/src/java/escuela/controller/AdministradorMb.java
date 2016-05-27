/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.controller;

import escuela.ws.Administrador;
import escuela.ws.MiService;
import escuela.ws.MiService_Service;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alumno-CT
 */
@ManagedBean
@SessionScoped
public class AdministradorMb {
    
    private String user;
    private String password;
    private String name;
    private String apellidos;
    private String codigo;    
    private String message;
    
    public void validar(){
        MiService_Service servicio = new MiService_Service();
        MiService port = servicio.getMiServicePort();
        name = port.validar(user, password);
    }
    
    public void crear(){
        MiService_Service servicio = new MiService_Service();
        MiService port = servicio.getMiServicePort();
        Administrador adm = new Administrador();
        adm.setChrAdmCodigo(codigo);
        adm.setChrAdmLogin(user);
        adm.setChrAdmPassword(password);
        adm.setVchAdmNombres(name);
        adm.setVchAdmApellidos(apellidos);
        port.create(adm);
        message = "usuario creado";
        
    }
            
            
    public AdministradorMb() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
