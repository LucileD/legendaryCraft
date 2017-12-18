package legendaryCraft.notification;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import legendaryCraft.personnage.Joueur;
import legendaryCraft.personnage.Personnage;

@Repository
public interface NotificationDurabilityRepository extends MongoRepository<NotificationDurability, String> {
	
	public NotificationDurability findByPersonnageAndJoueurAndNomItem(Personnage personnage,Joueur joueur, String nomItem);
	public List<NotificationDurability> findByJoueur(Joueur joueur);

}
