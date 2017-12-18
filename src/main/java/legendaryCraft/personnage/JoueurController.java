package legendaryCraft.personnage;

import java.security.Principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import legendaryCraft.notification.NotificationDurability;
import legendaryCraft.notification.NotificationDurabilityRepository;

@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class JoueurController {


	@Autowired
	private JoueurRepository joueurRepository;
	
	@Autowired
	private PersonnageRepository personnageRepository;
	
	@Autowired
	private NotificationDurabilityRepository nDRepository;
	
	@RequestMapping("/joueur")
	public String personnages(Principal principal, Model model) {
		Joueur j = joueurRepository.findByLogin(principal.getName());
	
		List<Personnage> personnages = personnageRepository.findByJoueur(j);
		List<NotificationDurability> nd = nDRepository.findByJoueur(j);

		model.addAttribute("notifs",nd);
		model.addAttribute("personnages", personnages);
		model.addAttribute("joueur", j);
		return "joueur";

	}
}


