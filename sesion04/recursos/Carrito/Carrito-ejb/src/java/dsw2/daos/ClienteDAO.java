package dsw2.daos;

import dsw2.beans.Cliente;
import dsw2.util.DBConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

    private Connection getConnection(){

	DBConn cnx=new DBConn();
	return cnx.getConnection();
}


    public Cliente validarCliente(String usuario, String password) throws SQLException{
        Cliente objCliente=null;
        String sql="SELECT * FROM Clientes WHERE login='"+usuario+"' AND password='"+password+"'";;
        Connection conn=getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);

        while(rst.next()){

            objCliente=new Cliente();

            objCliente.setCodigo(rst.getInt(1));
            objCliente.setLogin(rst.getString(2));
            objCliente.setPassword(rst.getString(3));
            objCliente.setNombre(rst.getString(4));
            objCliente.setDireccion(rst.getString(5));
            objCliente.setFonoCasa(rst.getString(6));
            objCliente.setFonoMovil(rst.getString(7));
            objCliente.setSexo(rst.getString(8));
            objCliente.setEmail(rst.getString(9));
            objCliente.setCiudad(rst.getString(10));
            objCliente.setSaldo(rst.getDouble(11));

        }

	rst.close();
	stm.close();
	conn.close();

	return objCliente;
    }
}
