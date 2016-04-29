
package cjava;

import cjava.beans.Curso;
import javax.ejb.Local;

@Local
public interface Ejb_stf_01Local {
    
    public int agregarItem(Curso curso);
    
    public Curso obtenerCurso(int indice);
    
    public Curso obtenerCurso(String codigo);
    
    
}
