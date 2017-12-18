package legendaryCraft.personnage;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import legendaryCraft.item.CaracteristiqueIntitule;
import legendaryCraft.item.Item;
import legendaryCraft.item.ItemRepository;
import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Rarete;


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
	public String personnage(Principal principal, @PathVariable String id, @RequestParam(value="type", required = false) String type, @RequestParam(value="rarete", required = false) String rarete, Model model) {
		Personnage personnage = repository.findOne(id);
		Joueur j = joueurRepository.findByLogin(principal.getName());
		List<Item> items = itemRepository.findByPersonnage(personnage);
		CaracteristiqueIntitule[] caracs = CaracteristiqueIntitule.values();
		int[] stats = personnage.statsOfPersonnage();

		// filtrage des items
		ItemType itemtype = null;
		if ((type != null) && (!type.equals("Tout"))) {
			itemtype = ItemType.valueOf(type.toUpperCase());
		}
		Rarete rareteItem = null;
		if ((rarete != null) && (!rarete.equals("Tout"))) {
			rareteItem = Rarete.valueOf(rarete);
		}
		
		if ((rareteItem == null) && (itemtype != null)) {
			items = itemRepository.findByItemType(itemtype);
		}
		if ((rareteItem != null) && (itemtype == null)) {
			items = itemRepository.findByRarete(rareteItem);
		}
		if ((rareteItem != null) && (itemtype != null)) {
			items = itemRepository.findByItemTypeAndRarete(itemtype, rareteItem);
		}
		
		if ( personnage.getJoueur().getId().equals(j.getId())){
			model.addAttribute("estMonPerso",true);
		}
		
		ItemType[] itemtypes = ItemType.values();
		model.addAttribute("personnage", personnage);
		model.addAttribute("items", items);
		model.addAttribute("itemtypes", itemtypes);
		model.addAttribute("caracs", caracs);
		model.addAttribute("stats", stats);
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
	
	
	@RequestMapping(value="/personnage/{idPersonnage}/equiper/{idItem}")
	public String equiperPersonnage(Model model, @PathVariable("idPersonnage") String idPersonnage, @PathVariable("idItem") String idItem) {
		Personnage personnage = repository.findOne(idPersonnage);
		Item item = itemRepository.findOne(idItem);
		if (item.getNiveauRequis() > personnage.niveau) {
			model.addAttribute("personnage", personnage);
			return "equiper_item_erreur";
		}
		
		// on équipe l'item
		switch (item.getItemType()){
		case AMULETTE:
			personnage.amulette = item;
			break;
		case ARC:
			personnage.arme = item;
			break;
		case ARMURE:
			personnage.armure = item;
			break;
		case BATON:
			personnage.arme = item;
			break;
		case BOTTES:
			personnage.bottes = item;
			break;
		case BOUCLIER:
			if ( personnage.arme.isAdeuxMains())
				personnage.setArme(null);
			personnage.bouclier = item;
			break;
		case CASQUE:
			personnage.casque = item;
			break;
		case CEINTURE:
			personnage.ceinture = item;
			break;
		case DAGUE:
			personnage.arme = item;
			break;
		case EPEE:
			personnage.arme = item;
			break;
		case HACHE:
			personnage.arme = item;
			break;
		case MASSE:
			personnage.arme = item;
			break;
		case PANTALON:
			personnage.pantalon = item;
			break;
		default:
			return "error";
		}
	
		if (item.isAdeuxMains()) {
			personnage.bouclier = null;
		}
		
		repository.save(personnage);
		model.addAttribute("personnage", personnage);
		model.addAttribute("item", item);
		return "equiper_item_success";
	}
	
}
