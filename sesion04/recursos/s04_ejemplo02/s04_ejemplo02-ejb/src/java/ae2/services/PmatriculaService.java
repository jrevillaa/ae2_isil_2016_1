package ae2.services;

import ae2.entities.Curso;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Profesor
 */
public interface PmatriculaService {
    public void insertCurso(Curso curso);
    public void deleteCurso(String id);
    public List<Curso> getItems();
    
    public boolean matricular(String id_alumno,
                                List<Curso> lista,
                                String id_ad,
                                Date fecha_mat);
}
