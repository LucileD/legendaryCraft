package legendaryCraft.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@Autowired
	NotificationDurabilityRepository repository;
	
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(NotificationDurability notif) {
		repository.save(notif);
        System.out.println("Received <" + notif + ">");
    }

}
