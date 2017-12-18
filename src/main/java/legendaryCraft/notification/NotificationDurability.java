package legendaryCraft.notification;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import legendaryCraft.personnage.Joueur;
import legendaryCraft.personnage.Personnage;

@Document(collection = "NotificationDurability")
public class NotificationDurability {

	@Id
	protected String id;
	
	protected Joueur joueur;
	
	protected Personnage personnage;
	
	protected String nomItem;
	
	public NotificationDurability() {
		this.id = new ObjectId().toString();
	}
	
	public NotificationDurability(Joueur joueur,Personnage personnage, String nomItem){
		this.id = new ObjectId().toString();
		this.joueur = joueur;
		this.nomItem = nomItem;
		this.personnage = personnage;
	}
	
	@Override
    public String toString() {
		return "NotificationDurability [id=" + id + ", joueur=" + joueur + ", item=" + nomItem + "]";
    }

	

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public String getNomItem() {
		return nomItem;
	}

	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}
	
	
}
