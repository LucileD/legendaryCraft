package legendaryCraft.notification;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import legendaryCraft.personnage.Joueur;

@Repository
public interface NotificationDurabilityRepository extends MongoRepository<NotificationDurability, String> {

	public NotificationDurability findById(String id);
	
	public List<NotificationDurability> findByJoueur(Joueur joueur);
}
