package legendaryCraft.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import legendaryCraft.item.enums.ItemType;
import legendaryCraft.personnage.Personnage;
import legendaryCraft.personnage.PersonnageRepository;

@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class ItemController {
	
	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private PersonnageRepository pRepository;

//	@RequestMapping("/items")
//	public String items(Model model, @RequestParam(value="type", required = false) String type) {	
//		List<Item> items;
//		if (type != null) {
//			// la variable doit etre au format "CASQUE", "EPEE", etc...
//			ItemType itemtype = ItemType.valueOf(type);
//			items = repository.findByItemType(itemtype);
//		} else {
//			items = repository.findAll();
//		}
//		model.addAttribute("items", items);
//		return "items";
//    }
	
	@RequestMapping("/item")
	public String itemAvecNom(@RequestParam("id") String id,Model model) {
		//return repository.findByNom(nom);
		Item item = repository.findOne(id);
		if (item == null){
			return "erreur";
		}
		model.addAttribute("item", item);
		if (item.isADeuxMains) {
			model.addAttribute("maniement", "2M");
		} else {
			model.addAttribute("maniement", "1M");
		}
		return "item";
    }
	
	@RequestMapping("/craft")
	public String craftItem(@RequestParam("id") String idPersonnage, Model model) {
		Personnage personnage = pRepository.findOne(idPersonnage);
		if (personnage == null)
			return "erreur";
		Item item = CraftUtils.craftItem(personnage);
		repository.save(item);

		model.addAttribute("idPersonnage", personnage.getId());
		if (item.isADeuxMains) {
			model.addAttribute("maniement", "2M");
		} else {
			model.addAttribute("maniement", "1M");
		}
		model.addAttribute("item", item);
		return "craft";
	}
}
