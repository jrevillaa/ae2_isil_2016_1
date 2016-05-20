/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dsw2.ejbs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Profesor
 */
@MessageDriven(mappedName = "queue/cola2", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
public class MDB02Bean implements MessageListener {
    
    public MDB02Bean() {
    }

     public void onMessage(Message msg) {
          MapMessage map = (MapMessage) msg;
          try {
                     String s1 = map.getString("nombre");
                     String s2 = map.getString("paterno");
                     double sueldo = map.getDouble("sueldo");
                     System.out.println( "Nombre: " +s1 );
                     System.out.println( "Paterno: " +s2 );
                     System.out.println( "Sueldo: " +sueldo );
          }catch(Exception ex) {
                  ex.printStackTrace();
          }
    
     }
}

