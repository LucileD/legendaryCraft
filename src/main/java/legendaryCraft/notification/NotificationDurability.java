package legendaryCraft.notification;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import legendaryCraft.item.Item;
import legendaryCraft.personnage.Joueur;
import legendaryCraft.personnage.Personnage;

@Document(collection = "NotificationDurability")
public class NotificationDurability {

	@Id
	protected String id;
	
	protected Personnage personnage;
	
	protected Item item;
	
	public NotificationDurability() {
		this.id = new ObjectId().toString();
	}
	
	public NotificationDurability(Personnage personnage, Item item){
		this.id = new ObjectId().toString();
		this.personnage = personnage;
		this.item = item;
	}
	
	@Override
    public String toString() {
		return "NotificationDurability [id=" + id + ", personnage=" + personnage + ", item=" + item + "]";
    }

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setJoueur(Personnage p) {
		this.personnage = p;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
