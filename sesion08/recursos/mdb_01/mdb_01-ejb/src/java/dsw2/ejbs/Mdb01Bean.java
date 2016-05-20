/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw2.ejbs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Profesor
 */
@MessageDriven(mappedName = "queue/lacolita", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
public class Mdb01Bean implements MessageListener {
    
    public Mdb01Bean() {
    }

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
