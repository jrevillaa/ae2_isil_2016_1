/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.ejbs;

import ae2.entidades.Clientes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface ClientesBeanLocal {

    String validarLocal(String us, String ps);
    int agregarCliente(Clientes cliente);
    int actualizarCliente(Clientes cliente);
    Clientes buscarClientes(int id);
    int borrarClientes(int id);
    List<Clientes> listarClientes();
    
    
}
