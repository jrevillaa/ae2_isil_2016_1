/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.controllers;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno-CT
 */
public class ServletProductor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InitialContext ctx = null;
        QueueConnection qcon = null;
        QueueSession qSession = null;
        QueueSender qsender = null;
        PrintWriter out = response.getWriter();

        try {
            ctx = new InitialContext();
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/mismensajes");

            //qcon =  factory.createQueueConnection("guest","guest");
            qcon = factory.createQueueConnection();
            qSession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue cola = (Queue) ctx.lookup("queue/lacolita");

            qsender = qSession.createSender(cola);
            TextMessage msg = qSession.createTextMessage();
            qcon.start();

            for (int i = 1; i <= 20; i++) {
                msg.setText("Mensaje " + i + " de " + request.getParameter("nombre"));
                qsender.send(msg);
            }

            out.println("<B>Su mensaje, ha sido enviado correctamente</B><br>");

            qcon.close();
        } catch (NamingException e) {
            out.println("<B>Error Naming,<B> " + e.toString());
        } catch (JMSException e) {
            out.println("<B>Error JMS,<B> " + e.toString());
        }
        out.close();
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
