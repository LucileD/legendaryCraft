package legendaryCraft.notification;

import java.util.List;

import legendaryCraft.item.Item;
import legendaryCraft.personnage.Joueur;

public class NotificationDurability {
	
	private Joueur joueur;
	
	private List<Item> items;
	
	
	public NotificationDurability() {
		
	}
	
	public NotificationDurability(Joueur j, List<Item> items){
		this.joueur = j;
		this.items=items;
	}
	
	@Override
    public String toString() {
        return String.format("notif");
    }

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur j) {
		this.joueur = j;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
