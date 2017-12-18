package legendaryCraft.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AutoConfigureDataMongo
@RequestMapping("/api")
public class ItemRestController {
	
	@Autowired
	private ItemRepository repository;
	
	private JoueurRepository jRepository;

	@RequestMapping("/items")
	public List<Item> items(Model model) {	
		return repository.findAll();
    }	
	
	@RequestMapping("/items/{id}")
	public Item itemAvecId(@PathVariable String id) {
		return repository.findOne(id);			
    }
	
	@RequestMapping("/item")
	public Item itemAvecNom(@RequestParam("nom") String nom,Model model) {
		return repository.findByNom(nom);
    }
	
	@RequestMapping(value="/item", method = RequestMethod.POST)
	public Item saveItem (@RequestBody Item item){
		return repository.save(item);
	}
	
	@RequestMapping(value="/item", method = RequestMethod.PUT )
	public Item modifItem (@RequestBody Item item){
		return repository.save(item);
	}
	
	@RequestMapping(value="/item", method = RequestMethod.DELETE )
	public void deleteItem (@RequestBody Item item){
		repository.delete(item);
	}
	
	@RequestMapping(value="/craft", method = RequestMethod.GET)
	public Item craftItem () {
		// récupérer l'id joueur d'une manière ou d'une autre
		Joueur joueur = jRepository.findOne(id_joueur);
		Item item = CraftUtils.craftItem(joueur);
		return repository.save(item);
	}
}
