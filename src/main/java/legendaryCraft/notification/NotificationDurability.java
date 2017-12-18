package legendaryCraft.notification;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import legendaryCraft.personnage.Personnage;

@Document(collection = "NotificationDurability")
public class NotificationDurability {

	@Id
	protected String id;
	
	protected Personnage personnage;
	
	protected String nomItem;
	
	public NotificationDurability() {
		this.id = new ObjectId().toString();
	}
	
	public NotificationDurability(Personnage personnage, String nomItem){
		this.id = new ObjectId().toString();
		this.personnage = personnage;
		this.nomItem = nomItem;
	}
	
	@Override
    public String toString() {
		return "NotificationDurability [id=" + id + ", personnage=" + personnage + ", item=" + nomItem + "]";
    }

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage p) {
		this.personnage = p;
	}

	public String getNomItem() {
		return nomItem;
	}

	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}
	
}
