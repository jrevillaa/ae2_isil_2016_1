package parcial.daos;

import parcial.beans.Cliente;
import parcial.util.DBConn;
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
        String sql="SELECT * FROM tb_cliente WHERE Cod_cli='"+usuario+"'";
        Connection conn=getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);

        while(rst.next()){

            objCliente=new Cliente();
            /*
Cod_cli
Raz_soc_cli
Dir_cli
Tel_cli
Ruc_cli
Cod_dis
Fec_reg
Tip_cli
Contacto
    */

            objCliente.setCod_cli(rst.getString(1));
            objCliente.setRaz_soc_cli(rst.getString(2));
            objCliente.setDir_cli(rst.getString(3));
            objCliente.setTel_cli(rst.getString(4));
            objCliente.setRuc_cli(rst.getString(5));
            objCliente.setCod_dis(rst.getString(6));
            objCliente.setFec_reg(rst.getDate(7));
            objCliente.setTip_cli(rst.getString(8));
            objCliente.setContacto(rst.getString(9));

        }

	rst.close();
	stm.close();
	conn.close();

	return objCliente;
    }
}
