/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.daos;

import ae2.entidades.Clientes;
import ae2.servicios.ClientesService;
import java.util.List;

/**
 *
 * @author Profesor
 */
public class ClientesDao implements ClientesService{

    @Override
    public Clientes validar(String u, String p) {
        Clientes administrador= null;
        if(u.equalsIgnoreCase("admin")&&p.equalsIgnoreCase("admin")){
            administrador = new Clientes();
            administrador.setNombres("juan");
            administrador.setApellidos("perez");
        }
        return administrador;
    }

    @Override
    public int grabar(Clientes cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Clientes cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clientes> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Clientes buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
