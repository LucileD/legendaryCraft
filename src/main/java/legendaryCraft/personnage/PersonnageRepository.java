package legendaryCraft.personnage;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonnageRepository  extends MongoRepository<Personnage,String>{

	public List<Personnage> findByJoueur(Joueur joueur);
	public Personnage findById (String id);
	
}
