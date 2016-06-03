/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.ws;

import ae2.entidades.TbProducto;
import ae2.fachadas.TbProductoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alumno-CT
 */
@WebService(serviceName = "MiServicio")
@Stateless()
public class MiServicio {

    @EJB
    private TbProductoFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "tbProducto") TbProducto tbProducto) {
        ejbRef.create(tbProducto);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "tbProducto") TbProducto tbProducto) {
        ejbRef.edit(tbProducto);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "tbProducto") TbProducto tbProducto) {
        ejbRef.remove(tbProducto);
    }

    @WebMethod(operationName = "find")
    public TbProducto find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<TbProducto> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<TbProducto> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "prodPerRange")
    public List<TbProducto> prodPerRange(@WebParam(name = "min") int min, @WebParam(name = "max") int max) {
        return ejbRef.prodPerRange(min, max);
    }

    @WebMethod(operationName = "findAllOrder")
    public List<TbProducto> findAllOrder() {
        return ejbRef.findAllOrder();
    }

    @WebMethod(operationName = "findByName")
    public List<TbProducto> findByName(@WebParam(name = "name") String name) {
        return ejbRef.findByName(name);
    }
    
}
