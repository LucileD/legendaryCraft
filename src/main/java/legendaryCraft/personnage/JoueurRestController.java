package legendaryCraft.personnage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AutoConfigureDataMongo
@RequestMapping("/api")
public class JoueurRestController {
	
	@Autowired
	private JoueurRepository repository;
	
	@RequestMapping(value="/joueur", method = RequestMethod.POST)
	public Joueur saveJoueur (@RequestBody Joueur joueur){
		return repository.save(joueur);
	}
	
	@RequestMapping("/joueur")
	public List<Joueur> joueurs(Model model) {	
		return repository.findAll();
    }
	
	@RequestMapping("/joueur/{id}")
	public Joueur joueurAvecId(@PathVariable String id) {	
		return repository.findById(id);
    }
	
	@RequestMapping("/joueur/{pseudo}")
	public Joueur joueurAvecPseudo(@PathVariable String pseudo) {	
		return repository.findByPseudo(pseudo);
    }
	
	@RequestMapping(value="/joueur", method = RequestMethod.PUT )
	public Joueur modifJoueur (@RequestBody Joueur joueur){
		return repository.save(joueur);
	}
	
	@RequestMapping(value="/joueur", method = RequestMethod.DELETE )
	public void deleteJoueur (@RequestBody Joueur joueur){
		repository.delete(joueur);
	}
	

}
