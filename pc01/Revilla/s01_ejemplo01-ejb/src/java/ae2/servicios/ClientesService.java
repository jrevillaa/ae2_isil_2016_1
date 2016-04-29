package ae2.servicios;

import ae2.entidades.Clientes;
import java.util.List;


public interface ClientesService {
    public Clientes validar(String u , String p);
    public int grabar(Clientes cliente);
    public int actualizar(Clientes cliente);
    public Clientes buscar(int id);
    public int borrar(int id);
    public List<Clientes> listar();
}
