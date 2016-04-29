/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ae2.ejbs;

import ae2.entities.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Profesor
 */
@Local
public interface CursoBeanLocal {

    void insertCurso(Curso curso);

    Curso findByIndex(int indice);

    Curso findById(String id);

    void deleteCurso(String id);

    List<Curso> findAll();
    
}
