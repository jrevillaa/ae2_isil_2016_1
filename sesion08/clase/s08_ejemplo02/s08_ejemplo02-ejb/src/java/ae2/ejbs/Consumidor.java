/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae2.ejbs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Alumno-CT
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/lacolita"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class Consumidor implements MessageListener {
    
    public Consumidor() {
    }
    
    @Override
    public void onMessage(Message message) {
        // Codigo inicial de mensajes recibidos
		String mensaje=null;
		try {
			mensaje = ((TextMessage)message).getText();
			System.out.println(mensaje);
		} catch (JMSException e) {
			System.out.println(e.toString());
		}
    }
    
}
