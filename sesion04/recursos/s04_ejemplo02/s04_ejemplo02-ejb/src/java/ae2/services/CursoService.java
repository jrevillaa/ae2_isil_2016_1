package ae2.services;

import ae2.entities.Curso;
import java.util.List;

/**
 *
 * @author Profesor
 */
public interface CursoService {
    public List<Curso> findAll();
    public Curso findbyId(String id);
    
}
