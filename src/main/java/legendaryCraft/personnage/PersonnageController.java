package legendaryCraft.personnage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import legendaryCraft.item.Item;

@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class PersonnageController {

	@Autowired
	private PersonnageRepository repository;
	
	@RequestMapping("/personnages")
	public String personnages(Model model) {
		List<Personnage> personnages = repository.findAll();
		model.addAttribute("personnages", personnages);
		return "personnages";
	}
}
