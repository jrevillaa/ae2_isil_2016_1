package parcial.ejbs;

import parcial.beans.Cliente;
import parcial.daos.ClienteDAO;
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
