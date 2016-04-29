/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ae2.servlets;

import ae2.ejbs.CursoBeanLocal;
import ae2.entities.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Profesor
 */
@WebServlet(name = "LlamaEjbServlet", urlPatterns = {"/llamaEJB"})
public class LlamaEjbServlet extends HttpServlet {

    @EJB
    private CursoBeanLocal ejb01;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<HTML> <HEAD> <TITLE>Servlet que llama EJB </TITLE> </HEAD> <BODY BGCOLOR=white>");
            out.println("<CENTER> <FONT size=+1> Llamando a un EJB:: Ingresa un nuevo Curso  </FONT> </CENTER> <p> ");
            out.println("<h3>Llamando al EJB</h3>");
            out.println("<h3>Ingrese un nuevo Curso</h3>");
            out.println("<form action='llamaEJB'>");
            out.println("<input type='text' name='cod'><br>");
            out.println("<input type='text' name='nom'><br>");
            out.println("<input type='text' name='cred'><br>");
            out.println("<input type='submit' value='enviar'>");
            out.println("</form>");
              
            String  codigo =request.getParameter("cod");
            String  nombre =request.getParameter("nom");
            int  creditos =Integer.parseInt(request.getParameter("cred"));
            
            Curso curso = new Curso();
            curso.setCodigo(codigo);
            curso.setNombre(nombre);
            curso.setCreditos(creditos);
            
            ejb01.insertCurso(curso);
           
            out.println("<table width=300>");
            for(Curso kurt: ejb01.findAll()){
                out.println("<tr>");
                out.println("       <td>"+ kurt.getCodigo() + "</td>");
                out.println("       <td>"+ kurt.getNombre() + "</td>");
                out.println("       <td>"+ kurt.getCreditos() + "</td>");
                out.println("</tr>");
            }
            out.println("</table></BODY> </HTML> ");

        } catch (Exception ex) {
            System.out.println("Fallo el llamado al EJB");
            throw new ServletException(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
