package dsw2.ejbs;

import dsw2.beans.Cliente;
import dsw2.daos.ClienteDAO;
import java.sql.SQLException;
import javax.ejb.Stateless;

@Stateless
public class ClienteBean implements ClienteLocal {

    public Cliente validarCliente(String usuario, String password) {
        try {
            return new ClienteDAO().validarCliente(usuario, password);
        } catch (SQLException ex) {
            return null;
        }
    }




}
