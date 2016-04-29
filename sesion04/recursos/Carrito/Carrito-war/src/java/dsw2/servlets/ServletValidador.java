package dsw2.servlets;

import dsw2.beans.Cliente;
import dsw2.ejbs.ClienteLocal;
import dsw2.ejbs.ProductoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletValidador extends HttpServlet {
   
    @EJB
    ClienteLocal cl;
    @EJB
    ProductoLocal pl;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

            HttpSession sesion = request.getSession();
            Cliente cliente = cl.validarCliente(request.getParameter("txtUsuario"),
                                         request.getParameter("txtPassword"));
            if(cliente!=null){
                sesion.setAttribute("listaproductos", pl.obtenerListaProductos());
                sesion.setAttribute("scliente", cliente);
                response.sendRedirect("Principal.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }



    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
