package legendaryCraft.notification;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import legendaryCraft.personnage.Personnage;

@Repository
public interface NotificationDurabilityRepository extends MongoRepository<NotificationDurability, String> {
	
	public List<NotificationDurability> findByPersonnageAndNomItem(Personnage personnage, String nomItem);
	
}
