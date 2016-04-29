package cjava;

import cjava.beans.Curso;
import java.io.*;

import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @Edwin Maraví
 * @version 1.0
 */
public class Srv_LlamaEJB extends HttpServlet {
    
     @EJB
    private Ejb_stf_01Local ejb01;

    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {

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
              
            String  codigo =req.getParameter("cod");
            String  nombre =req.getParameter("nom");
            int  creditos =Integer.parseInt(req.getParameter("cred"));
            
            Curso curso = new Curso();
            curso.setCodigo(codigo);
            curso.setNombre(nombre);
            curso.setCreditos(creditos);
            
            int can_cursos= ejb01.agregarItem(curso);
           
            out.println("<table width=300>");
           for(int i=0 ; i<can_cursos ; i++){
                out.println("<tr>");
                out.println("       <td>"+ ejb01.obtenerCurso(i).getCodigo() + "</td>");
                out.println("       <td>"+ ejb01.obtenerCurso(i).getNombre() + "</td>");
                out.println("       <td>"+ ejb01.obtenerCurso(i).getCreditos() + "</td>");
                out.println("</tr>");
            }
            out.println("</table></BODY> </HTML> ");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Fallo el llamado al EJB");
            throw new ServletException(ex);
        }
    }
}
