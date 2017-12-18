package legendaryCraft.notification;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class NotificationController {

	@Autowired
	NotificationDurabilityRepository repository;
	
	@RequestMapping("/notification/supprimer/{id}")
	public void supprimerNotif(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
		NotificationDurability notif = repository.findOne(id);
		repository.delete(notif);
		response.sendRedirect("/app/joueur");
	}
}
