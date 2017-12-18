package legendaryCraft.notification;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import legendaryCraft.item.Item;
import legendaryCraft.personnage.Joueur;

@Document(collection = "NotificationDurability")
public class NotificationDurability {

	@Id
	protected String id;
	
	private Joueur joueur;
	
	private Item item;
	
	public NotificationDurability() {
		this.id = new ObjectId().toString();
	}
	
	public NotificationDurability(Joueur j, Item item){
		this.id = new ObjectId().toString();
		this.joueur = j;
		this.item = item;
	}
	
	@Override
    public String toString() {
		return "NotificationDurability [id=" + id + ", joueur=" + joueur + ", item=" + item + "]";
    }

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur j) {
		this.joueur = j;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
