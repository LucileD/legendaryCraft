package legendaryCraft.notification;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(NotificationDurability notif) {
		//mettre notif bdd ici
        System.out.println("Received <" + notif + ">");
    }

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage2(NotificationDurability notif) {
		//mettre notif bdd ici
        System.out.println("Received2 <" + notif + ">");
    }
}
