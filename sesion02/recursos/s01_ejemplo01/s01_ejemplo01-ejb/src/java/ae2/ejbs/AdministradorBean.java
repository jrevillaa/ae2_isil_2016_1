package ae2.ejbs;

import ae2.daos.AdministradorDao;
import ae2.daos.AdministradorJdbcDao;
import ae2.entidades.Administrador;
import ae2.servicios.AdministradorService;
import javax.ejb.Stateless;

/**
 *
 * @author Profesor
 */
@Stateless
public class AdministradorBean implements AdministradorBeanLocal {

    @Override
    public String validarLocal(String us, String ps) {
        AdministradorService dao = new AdministradorJdbcDao();
        Administrador adm = dao.validar(us, ps);
        if(adm!=null){
            return adm.getNombres()+" "+adm.getApellidos();
        }
        return "no existe";
    }

    
    
}
