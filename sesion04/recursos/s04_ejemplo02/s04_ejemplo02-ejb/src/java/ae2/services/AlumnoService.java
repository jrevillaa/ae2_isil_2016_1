
package ae2.services;

import ae2.entities.Alumno;
import java.util.List;

/**
 *
 * @author Profesor
 */
public interface AlumnoService {
    public List<Alumno> findAll();
    public Alumno findById(String id);
}
