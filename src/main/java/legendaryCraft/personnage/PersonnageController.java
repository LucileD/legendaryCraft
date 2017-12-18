package legendaryCraft.personnage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import legendaryCraft.item.Item;


@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class PersonnageController {

	@Autowired
	private PersonnageRepository repository;
	
	@Autowired
	private JoueurRepository joueurRepository;

	@RequestMapping("/personnage/{id}")
	public String personnage(@PathVariable String id, Model model) {
		Personnage personnage = repository.findOne(id);
		model.addAttribute("personnage", personnage);
		return "personnage";
	}
	
	@RequestMapping("/nouv_personnage")
	public String newPersonnageG(Model model) {
		return "nouvPersonnage";
	}
	
	@RequestMapping(value="/nouv_personnage", method=RequestMethod.POST)
	public void newPersonnageP(Model model,@RequestParam String pseudo, @RequestParam String niveau,HttpServletResponse response) throws IOException {
		Joueur joueur = joueurRepository.findByPseudo("TrucMuche");
		repository.save(new Personnage(pseudo,joueur,Integer.parseInt(niveau)));
		response.sendRedirect("/app/joueur");
	}
	
}
