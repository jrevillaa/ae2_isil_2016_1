package cjava.beans;

import java.io.Serializable;

/**
 *
 * @author Edwin Maravi
 *  emaravi@cjavaperu.com
 */
public class Curso implements Serializable{
    
    private String codigo = null;
    private String Nombre=null;
    private int creditos=0;
    
    public Curso() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    
}
