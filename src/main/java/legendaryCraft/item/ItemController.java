package legendaryCraft.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class ItemController {
	
	@Autowired
	private ItemRepository repository;

	@RequestMapping("/items")
	public String items(Model model) {	
		List<Item> items = repository.findAll();
		model.addAttribute("items", items);
		return "items";
    }	
	
	@RequestMapping("/item")
	public String itemAvecNom(@RequestParam("nom") String nom,Model model) {
		//return repository.findByNom(nom);
		Item item = repository.findByNom(nom);
		if (item == null){
			return "erreur";
		}
		model.addAttribute("item", item);
		return "item";
    }
}
