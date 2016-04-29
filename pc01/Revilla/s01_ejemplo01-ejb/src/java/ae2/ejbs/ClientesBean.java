package ae2.ejbs;

import ae2.daos.ClientesDao;
import ae2.daos.ClientesJdbcDao;
import ae2.entidades.Clientes;
import javax.ejb.Stateless;
import ae2.servicios.ClientesService;
import java.util.List;

/**
 *
 * @author Profesor
 */
@Stateless
public class ClientesBean implements ClientesBeanLocal {

    @Override
    public String validarLocal(String us, String ps) {
        ClientesService dao = new ClientesJdbcDao();
        Clientes adm = dao.validar(us, ps);
        if(adm!=null){
            return adm.getNombres()+" "+adm.getApellidos();
        }
        return "no existe";
    }

    @Override
    public int agregarCliente(Clientes cliente) {
        ClientesService dao = new ClientesJdbcDao();
        int adm = dao.grabar(cliente);
        
        return adm;
    }

    @Override
    public int actualizarCliente(Clientes cliente) {
        ClientesService dao = new ClientesJdbcDao();
        int adm = dao.actualizar(cliente);
        
        return adm;
    }

    @Override
    public Clientes buscarClientes(int id) {
        ClientesService dao = new ClientesJdbcDao();
        Clientes adm = dao.buscar(id);
        
        return adm;
    }

    @Override
    public int borrarClientes(int id) {
        ClientesService dao = new ClientesJdbcDao();
        int adm = dao.borrar(id);
        
        return adm;
    }

    @Override
    public List<Clientes> listarClientes() {
        ClientesService dao = new ClientesJdbcDao();
        List<Clientes> adm = dao.listar();
        
        return adm;
    }

    
    
}
