/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.daos;

import ae2.entidades.Administrador;
import ae2.servicios.AdministradorService;
import ae2.util.UbicadorServicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Profesor
 */
public class AdministradorJdbcDao implements AdministradorService{
    Connection conn=null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    @Override
    public Administrador validar(String u, String p) {
        Administrador administrador=null;
        try {
            UbicadorServicios ubicador = UbicadorServicios.getInstance();
            DataSource ds = ubicador.getDataSource("jdbc/__default");
            conn = ds.getConnection(); 
            pst = conn.prepareStatement("select * from administrador where chrAdmLogin=? and chrAdmPassword=?");
            pst.setString(1,u);
            pst.setString(2,p);
            rst = pst.executeQuery();
            if(rst.next()){
                administrador=new Administrador();
                administrador.setCodigo(rst.getString(1));  
                administrador.setLogin(rst.getString(2));  
                administrador.setPassword(rst.getString(3));  
                administrador.setNombres(rst.getString(4));  
                administrador.setApellidos(rst.getString(5));  
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  catch (NamingException ex) {
            ex.printStackTrace();
        } //obtener prestado una conexion del pool
       return administrador;
    }
   
}
