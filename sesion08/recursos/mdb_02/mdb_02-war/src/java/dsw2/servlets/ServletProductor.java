package dsw2.servlets;

import java.io.*;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Edwin Maravi
 * @version 1.0
 * emaravi@cjavaperu.com
 */
public class ServletProductor extends HttpServlet {

    private MapMessage mensaje;

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		InitialContext ctx = null;
		QueueConnection qcon=null;
		QueueSession qSession=null;
		QueueSender qsender=null;
		PrintWriter out=response.getWriter();


		try {
			ctx = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory)ctx.lookup("jms/datos");

			//qcon =  factory.createQueueConnection("guest","guest");
            qcon =  factory.createQueueConnection();
			qSession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue cola = (Queue) ctx.lookup("queue/cola2");

			qsender = qSession.createSender(cola);
			mensaje = qSession.createMapMessage();

            mensaje.setString("nombre", request.getParameter("txtPaterno") );
            mensaje.setString("paterno", request.getParameter("txtMaterno") );
            mensaje.setDouble("sueldo",Double.parseDouble(request.getParameter("txtSueldo")) );

			qcon.start();

			qsender.send(mensaje);

			out.println("<B>Su mensaje, ha sido enviado correctamente</B><br>");

			qcon.close();
		} catch (NamingException e) {
                        out.println("<B>Error Naming,<B> "+e.toString());
		} catch (JMSException e) {
			out.println("<B>Error JMS,<B> "+e.toString());
		}
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
