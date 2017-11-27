package legendaryCraft.items;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends MongoRepository<Item, String>  {
	public Item findByNom (String nom);
	public Item findById (String id);

}
