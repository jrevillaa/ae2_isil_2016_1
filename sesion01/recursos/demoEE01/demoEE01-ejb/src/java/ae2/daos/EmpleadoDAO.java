package ae2.daos;

import ae2.service.EmpleadoService;

public class EmpleadoDAO implements EmpleadoService{

	@Override
	public String validar(String us, String ps) {
		return ((us.equals("admin")&&(ps.equals("admin"))))?"juan":"no existe";
	}
	
}
