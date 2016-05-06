package parcial.daos;

import parcial.beans.Producto;
import parcial.util.DBConn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ProductoDAO {

    Vector<Producto> vProducto = null;
    Connection cn = null;
    Statement st = null;
    ResultSet rs= null;
    public ProductoDAO(){
        vProducto = new Vector<Producto>();
    }

    public Vector<Producto> obtenerProductos() throws SQLException{
         cn= new  DBConn().getConnection();
         st = cn.createStatement();
         rs = st.executeQuery("select * from tb_producto");
        while(rs.next()){
            vProducto.add(new Producto(rs.getString(1),
                                                                rs.getString(2),
                                                                rs.getDouble(3),
                                                                rs.getInt(4),
                                                                rs.getInt(5),
                                                                rs.getString(6),
                                                                rs.getInt(7)));
        }
         cn.close();
        return vProducto;
    }

    public Producto obtenerProducto(int codigo) throws SQLException{
         cn= new  DBConn().getConnection();
         st = cn.createStatement();
         rs = st.executeQuery("select * from productos where codigo="+codigo);
        if(rs.next()){
            return new Producto(rs.getString(1),
                                                                rs.getString(2),
                                                                rs.getDouble(3),
                                                                rs.getInt(4),
                                                                rs.getInt(5),
                                                                rs.getString(6),
                                                                rs.getInt(7));
        }
         cn.close();
        return null;
    }

}
