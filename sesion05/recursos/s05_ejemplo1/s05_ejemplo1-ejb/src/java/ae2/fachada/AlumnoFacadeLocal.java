/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.fachada;

import ae2.entidades.Alumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno-CT
 */
@Local
public interface AlumnoFacadeLocal {

    void create(Alumno alumno);

    void edit(Alumno alumno);

    void remove(Alumno alumno);

    Alumno find(Object id);

    List<Alumno> findAll();

    List<Alumno> findRange(int[] range);

    int count();
    
}
