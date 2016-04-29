/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.daos;

import ae2.entidades.Clientes;
import ae2.util.UbicadorServicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;
import ae2.servicios.ClientesService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor
 */
public class ClientesJdbcDao implements ClientesService{
    Connection conn=null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    @Override
    public Clientes validar(String u, String p) {
        Clientes administrador=null;
        /*try {
            UbicadorServicios ubicador = UbicadorServicios.getInstance();
            DataSource ds = ubicador.getDataSource("jdbc/__default");
            conn = ds.getConnection(); 
            pst = conn.prepareStatement("select * from administrador where chrAdmLogin=? and chrAdmPassword=?");
            pst.setString(1,u);
            pst.setString(2,p);
            rst = pst.executeQuery();
            if(rst.next()){
                administrador=new Clientes();
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
        } //obtener prestado una conexion del pool*/
       return administrador;
    }

    @Override
    public int grabar(Clientes cliente) {
        int output = 0;
        
        try{
            UbicadorServicios ubicador = UbicadorServicios.getInstance();
            DataSource ds = ubicador.getDataSource("jdbc/__default");
            conn = ds.getConnection(); 
            pst = conn.prepareStatement("INSERT INTO clientes(apellidos,nombres,correo,telefono) VALUE (?,?,?,?)");
            pst.setString(1,cliente.getApellidos());
            pst.setString(2,cliente.getNombres());
            pst.setString(3,cliente.getCorreo());
            pst.setString(4,cliente.getTelefono());
            pst.executeUpdate();

            pst.close();
            conn.close();
            output = 1;
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(NamingException ex){
            ex.printStackTrace();
        }
        
        return output;
    }

    @Override
    public int actualizar(Clientes cliente) {
        if (buscar(cliente.getIdCliente()) != null) {
            try {
                String sql = "update clientes set apellidos =?, nombres =?, correo =?, telefono =? where idCliente=?";
                UbicadorServicios ubicador = UbicadorServicios.getInstance();
                DataSource ds = ubicador.getDataSource("jdbc/__default");
                conn = ds.getConnection(); 
                pst = conn.prepareStatement(sql);
                
                pst.setString(1, cliente.getApellidos());
                pst.setString(2, cliente.getNombres());
                pst.setString(3, cliente.getCorreo());
                pst.setString(4, cliente.getTelefono());
                pst.setInt(5, cliente.getIdCliente());
                pst.executeUpdate();

                pst.close();
                conn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error " + ex.getMessage());
            } catch (NamingException ex) {
                Logger.getLogger(ClientesJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 0;
    }

    @Override
    public List<Clientes> listar() {
        Clientes cliente;
        List<Clientes> lista = new ArrayList<>();
        try {
            String sql = "select*from clientes";
            UbicadorServicios ubicador = UbicadorServicios.getInstance();
            DataSource ds = ubicador.getDataSource("jdbc/__default");
            conn = ds.getConnection(); 
            pst = conn.prepareStatement(sql);
            rst = pst.executeQuery();
            while (rst.next()) {
                cliente = new Clientes();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setApellidos(rst.getString(2));
                cliente.setNombres(rst.getString(3));
                cliente.setCorreo(rst.getString(4));
                cliente.setTelefono(rst.getString(5));
                lista.add(cliente);
            }

            rst.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error!!: " + ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(ClientesJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Clientes buscar(int id) {
        Clientes cliente = null;
        try {
            String sql = "select*from clientes where idCliente=?";
            UbicadorServicios ubicador = UbicadorServicios.getInstance();
            DataSource ds = ubicador.getDataSource("jdbc/__default");
            conn = ds.getConnection(); 
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rst = pst.executeQuery();
            if (rst.next()) {
                cliente = new Clientes();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setApellidos(rst.getString(2));
                cliente.setNombres(rst.getString(3));
                cliente.setCorreo(rst.getString(4));
                cliente.setTelefono(rst.getString(5));
            }

            rst.close();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(ClientesJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public int borrar(int id) {
        if (buscar(id) != null) {
            try {
                String sql = "delete from clientes where idCliente=?";
                UbicadorServicios ubicador = UbicadorServicios.getInstance();
                DataSource ds = ubicador.getDataSource("jdbc/__default");
                conn = ds.getConnection(); 
                pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();

                pst.close();
                conn.close();
                return 1;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (NamingException ex) {
                Logger.getLogger(ClientesJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

    }
   
}
