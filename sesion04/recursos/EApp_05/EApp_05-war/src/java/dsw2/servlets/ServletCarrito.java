package dsw2.servlets;

import dsw2.beans.Producto;
import dsw2.ejbs.ProductoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletCarrito extends HttpServlet {

    @EJB
    ProductoLocal pl;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Producto producto = new Producto();
        producto.setCodigo(Integer.parseInt(request.getParameter("txtCodigo")));
        producto.setNombre(request.getParameter("txtNombre"));
        producto.setPrecio(Double.parseDouble(request.getParameter("txtPrecio"))) ;
        producto.setStock(Integer.parseInt(request.getParameter("txtStock")));

        HttpSession sesion = request.getSession();

        sesion.setAttribute("lista", pl.agregarProducto(producto));
        
        response.sendRedirect("carrito.jsp");

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
