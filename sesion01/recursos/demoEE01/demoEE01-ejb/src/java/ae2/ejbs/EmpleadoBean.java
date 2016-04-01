package ae2.ejbs;

import ae2.daos.EmpleadoDAO;
import javax.ejb.Stateless;


@Stateless
public class EmpleadoBean implements EmpleadoBeanLocal {

	@Override
	public String validar(String usuario, String password) {
		return new EmpleadoDAO().validar(usuario, password);
	}

	
}
