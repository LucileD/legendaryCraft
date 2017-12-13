package legendaryCraft.personnage;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class JoueurController {
	
	@Autowired
	private JoueurRepository repository;
	
	@RequestMapping("/joueur")
	public String loging(Principal principal, Model model) {	
		Joueur j = repository.findByLogin(principal.getName());
		model.addAttribute("joueur", j);
		return "joueur";
    }

}
