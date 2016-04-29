package ae2.ejbs;

import ae2.entities.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Profesor
 */
@Stateful
public class CursoBean implements CursoBeanLocal {

    List<Curso> listaCursos = new ArrayList<>();

    @Override
    public void insertCurso(Curso curso) {
        listaCursos.add(curso);
    }

    @Override
    public Curso findByIndex(int indice) {
        return listaCursos.get(indice);
    }

    @Override
    public Curso findById(String id) {
        for(Curso curso:listaCursos){
            if(curso.getCodigo().equals(id))
                return curso;
        }
        return null;
    }

    @Override
    public void deleteCurso(String id) {
        for(Curso curso:listaCursos){
            if(curso.getCodigo().equals(id))
                listaCursos.remove(curso);
        }
    }

    @Override
    public List<Curso> findAll() {
        return listaCursos;
    }
    
    
    
    
    
}
