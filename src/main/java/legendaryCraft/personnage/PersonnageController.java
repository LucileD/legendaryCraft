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
import legendaryCraft.item.ItemRepository;
import legendaryCraft.item.enums.ItemType;


@Controller
@AutoConfigureDataMongo
@RequestMapping("/app")
public class PersonnageController {

	@Autowired
	private PersonnageRepository repository;
	
	@Autowired
	private JoueurRepository joueurRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@RequestMapping("/personnage/{id}")
	public String personnage(@PathVariable String id, @RequestParam(value="type", required = false) String type, Model model) {
		Personnage personnage = repository.findOne(id);
		System.out.println();
		List<Item> items = itemRepository.findByPersonnage(personnage);
		if (type != null) {
			// la variable doit etre au format "CASQUE", "EPEE", etc...
			ItemType itemtype = ItemType.valueOf(type.toUpperCase());
			items = itemRepository.findByItemType(itemtype);
		} else {
			items = itemRepository.findAll();
		}
		ItemType[] itemtypes = ItemType.values();
		
		model.addAttribute("personnage", personnage);
		model.addAttribute("items", items);
		model.addAttribute("itemtypes", itemtypes);
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
