package legendaryCraft.personnage;

import java.security.Principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

		model.addAttribute("estConnecte",true);
		model.addAttribute("notifs",nd);
		model.addAttribute("personnages", personnages);
		model.addAttribute("joueur", j);
		return "joueur";

	}
	
	@RequestMapping("/joueur/{id}")
	public String personnagesAutreJoueur(Model model, @PathVariable("id") String id) {
		Joueur j = joueurRepository.findOne(id);
		List<Personnage> personnages = personnageRepository.findByJoueur(j);
		
		model.addAttribute("estConnecte", false);
		model.addAttribute("personnages", personnages);
		model.addAttribute("joueur", j);
		return "joueur";
	}
	
	@RequestMapping("/joueurs")
	public String listeDesJoueurs(Principal principal, Model model) {
		List<Joueur> joueurs = joueurRepository.findAll();
		
		int indexToRemove = -1;
		for (int i = 0; i < joueurs.size(); i++) {
			if (joueurs.get(i).getLogin().equals(principal.getName())) {
				indexToRemove = i;
			}
		}
		if (indexToRemove != -1) {
			joueurs.remove(indexToRemove);
		}
		model.addAttribute("joueurs", joueurs);
		return "joueurs";
	}
}


