package legendaryCraft.personnage;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class JoueurController {
	

	@Autowired
	private JoueurRepository joueurRepository;
	
	@Autowired
	private PersonnageRepository personnageRepository;
	
	@RequestMapping("/joueur")
	public String personnages(Principal principal, Model model) {
		Joueur j = joueurRepository.findByLogin(principal.getName());
	
		List<Personnage> personnages = personnageRepository.findByJoueur(j);
		model.addAttribute("personnages", personnages);
		return "personnages";
	}
}


