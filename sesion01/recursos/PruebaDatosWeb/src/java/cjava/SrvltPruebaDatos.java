package cjava;

import java.io.*;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import util.UbicadorServicios;

/**
 *
 * @author Edwin Maravi
 * @version 1.0
 */
public class SrvltPruebaDatos extends HttpServlet {
    Connection conn=null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
  
         
        try {
            UbicadorServicios ubicador = UbicadorServicios.getInstance();
            DataSource ds = ubicador.getDataSource("jdbc/escuelaDB");
            conn = ds.getConnection(); //obtener prestado una conexion del pool
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  catch (NamingException ex) {
            ex.printStackTrace();
        } //obtener prestado una conexion del pool
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Prueba de Conexion a BD </title>");
        out.println("</head>");
        out.println("<body>");
        if(conn==null)
                 out.println("<h1>Fallo la conexión </h1>");
        else
                  out.println("<h1>Se conecto a la base de datos</h1>");
        out.println("</body>");
        out.println("</html>");
    
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
