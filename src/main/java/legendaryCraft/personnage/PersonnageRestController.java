package legendaryCraft.personnage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonnageRestController {
	
	@Autowired
	private PersonnageRepository repository;

	
	@RequestMapping(value="/personnage", method = RequestMethod.POST)
	public Personnage savepersonnage (@RequestBody Personnage personnage){
		return repository.save(personnage);
	}
	
	@RequestMapping("/personnage")
	public List<Personnage> personnages(Model model) {	
		return repository.findAll();
    }
	
	@RequestMapping("/personnage/{id}")
	public Personnage personnageAvecId(@PathVariable String id) {	
		return repository.findOne(id);
    }
	
	@RequestMapping("/personnage/{nom}")
	public Personnage personnageAvecNom(@PathVariable String nom) {	
		return repository.findByNom(nom);
    }
	
	@RequestMapping(value="/personnage/joueur", method = RequestMethod.POST)
	public List<Personnage> personnagesDUnJoueur(@RequestBody Joueur joueur) {	
		return repository.findByJoueur(joueur);
    }
	
	@RequestMapping(value="/personnage", method = RequestMethod.PUT )
	public Personnage modifpersonnage (@RequestBody Personnage personnage){
		return repository.save(personnage);
	}
	
	@RequestMapping(value="/personnage", method = RequestMethod.DELETE )
	public void deletePersonnage (@RequestBody Personnage personnage){
		repository.delete(personnage);
	}
	

}
