package legendaryCraft.personnage;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

	
@Repository
public interface JoueurRepository extends MongoRepository<Joueur, String>  {
	public Joueur findByPseudo (String pseudo);
	public Joueur findById (String id);
	public Joueur findByLogin (String login);

}


