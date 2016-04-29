/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.fachada;

import ae2.entidades.Administrador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno-CT
 */
@Local
public interface AdministradorFacadeLocal {

    void create(Administrador administrador);

    void edit(Administrador administrador);

    void remove(Administrador administrador);

    Administrador find(Object id);

    List<Administrador> findAll();

    List<Administrador> findRange(int[] range);

    int count();

    Administrador validar(String us, String ps);
    
}
