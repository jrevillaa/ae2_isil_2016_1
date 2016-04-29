package cjava;

import cjava.beans.Curso;
import java.util.Vector;
import javax.ejb.Stateful;

/**
 *
 * @author Edwin Maravi
 */
@Stateful
public class Ejb_stf_01Bean implements cjava.Ejb_stf_01Local {

    Vector <Curso> vCurso = new Vector<Curso>();
    
    public Ejb_stf_01Bean() {
    }

    public int agregarItem(Curso curso) {
       vCurso.addElement(curso); 
       return vCurso.size();
    }

    public Curso obtenerCurso(int indice) {
        return vCurso.elementAt(indice);
    }

    public Curso obtenerCurso(String codigo) {
        //realizar el código necesario para retornar curso por codigo
        return null;
    }
    
    
    
    
}
