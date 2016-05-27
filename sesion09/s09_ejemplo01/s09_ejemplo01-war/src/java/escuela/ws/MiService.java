/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.ws;

import escuela.entidades.Administrador;
import escuela.fachadas.AdministradorFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Alumno-CT
 */
@WebService(serviceName = "MiService")
public class MiService {

    @EJB
    private AdministradorFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "administrador") Administrador administrador) {
        ejbRef.create(administrador);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "administrador") Administrador administrador) {
        ejbRef.edit(administrador);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "administrador") Administrador administrador) {
        ejbRef.remove(administrador);
    }

    @WebMethod(operationName = "find")
    public Administrador find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Administrador> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Administrador> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "validar")
    public String validar(@WebParam(name = "u") String u, @WebParam(name = "p") String p) {
        return ejbRef.validar(u, p);
    }
    
}
