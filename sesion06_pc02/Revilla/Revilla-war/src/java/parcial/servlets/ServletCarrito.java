package parcial.servlets;

import parcial.beans.Cliente;
import parcial.beans.Elemento;
import parcial.beans.Producto;
import parcial.ejbs.CarritoLocal;
import parcial.ejbs.ProductoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletCarrito extends HttpServlet {
   
    @EJB
    ProductoLocal pl;
    @EJB
    CarritoLocal cal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String actividad = request.getParameter("accion");

        if(actividad.equals("Agregar")){
             int cproducto = Integer.parseInt(request.getParameter("txtCodProducto"));
             int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
             //obtener el producto
             Producto producto = pl.buscarProducto(cproducto);
             //creacion de elemento para agregarlo al carrito
             Elemento elemento = new Elemento();
             elemento.setCodigo(producto.getCod_pro());
             elemento.setDescripcion(producto.getDes_pro());
             elemento.setPrecio(producto.getPre_pro());
             elemento.setCantidad(cantidad);
             elemento.setMonto(producto.getPre_pro()*cantidad);
             sesion.setAttribute("carrito",cal.agregarItem(elemento));
             response.sendRedirect("Carrito.jsp");
        }
        if(actividad.equals("Eliminar")){
            String cproducto = request.getParameter("rbtCodigo");
            cal.eliminarItem(cproducto);
            sesion.setAttribute("carrito",cal.obtenerItems());
            response.sendRedirect("Carrito.jsp");
        }
        if(actividad.equals("Ordenar")){
            Cliente cliente = (Cliente)request.getSession().getAttribute("scliente");
            cal.realizarPedido(cliente.getCod_cli());
            response.sendRedirect("Orden.jsp");
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
