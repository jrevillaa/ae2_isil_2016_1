package ae2.services;

import ae2.entities.Administrador;

/**
 *
 * @author Profesor
 */
public interface AdministradorService {
    
    public Administrador validar(String user, String pass);
    
}
