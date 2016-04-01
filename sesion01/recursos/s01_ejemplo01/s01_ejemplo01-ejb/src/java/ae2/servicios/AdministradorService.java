/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.servicios;

import ae2.entidades.Administrador;

/**
 *
 * @author Alumno-CT
 */
public interface AdministradorService {
    public Administrador validar(String u, String p);
}
