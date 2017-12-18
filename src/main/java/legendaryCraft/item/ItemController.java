package legendaryCraft.item;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import legendaryCraft.item.enums.ItemType;
import legendaryCraft.personnage.JoueurRepository;
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
	
	@Autowired
	private JoueurRepository jRepository;

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
	
	@RequestMapping("/item/{idPersonnage}/{id}")
	public String itemAvecNom(@PathVariable("idPersonnage") String idPersonnage, @PathVariable("id") String id, Model model) {
		Item item = repository.findOne(id);
		if (item == null){
			return "erreur";
		}
		model.addAttribute("item", item);
		if (item.isArme()) {
			if (item.isADeuxMains) {
				model.addAttribute("maniement", "2M");
			} else {
				model.addAttribute("maniement", "1M");
			}
		}
		model.addAttribute("idPersonnage", idPersonnage);
		return "item";
    }
	
	@RequestMapping("/item/supprimer/{idPersonnage}/{idItem}")
	public void supprimerItem(Model model, @PathVariable("idPersonnage") String idPersonnage, @PathVariable("idItem") String idItem, HttpServletResponse response) throws IOException {
		Item item = repository.findOne(idItem);
		repository.delete(item);
		response.sendRedirect("/app/personnage/" + idPersonnage);
	}
	
	@RequestMapping("/item/craft/{idPersonnage}")
	public String craftItem(Principal principal, @PathVariable("idPersonnage") String idPersonnage, Model model) {
		Personnage personnage = pRepository.findOne(idPersonnage);
		if (personnage == null)
			return "erreur";
		Item item = CraftUtils.craftItem(personnage);
		repository.save(item);

		model.addAttribute("idPersonnage", personnage.getId());
		if (item.isArme()) {
			if (item.isADeuxMains) {
				model.addAttribute("maniement", "2M");
			} else {
				model.addAttribute("maniement", "1M");
			}
		}
		model.addAttribute("item", item);
		return "craft";
	}
}
