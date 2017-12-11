package legendaryCraft.item;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Rarete;
import legendaryCraft.item.enums.Slot;

@Repository
@Order(2)
public interface ItemRepository extends MongoRepository<Item, String>  {
	
	public Item findByNom (String nom);
	
	public Item findById (String id);
	
	public List<Item> findByItemType(ItemType type);
	
	public List<Item> findByRarete(Rarete rarete);
	
	public List<Item> findByItemTypeAndRarete(ItemType type, Rarete rarete);
	
	// ne marche pas, on verra plus tard
	public List<Item> findBySlots(List<Slot> slots);
}
