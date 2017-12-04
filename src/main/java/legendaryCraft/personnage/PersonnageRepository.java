package legendaryCraft.personnage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Repository
public interface PersonnageRepository  extends MongoRepository<Personnage,String>{

	public List<Personnage> findByJoueur(Joueur joueur);
	public Personnage findById (String id);
	
}
