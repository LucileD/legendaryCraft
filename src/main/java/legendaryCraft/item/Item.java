package legendaryCraft.item;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Rarete;
import legendaryCraft.item.enums.Slot;

@Document(collection = "Item")
public class Item {
	
	@Id
	protected String id;
	
	protected int resTotale;
	
	protected int res ;
	
	protected int niveauRequis;
	
	protected String nom;
	
	protected ItemType itemType;
	
	protected List<Caracteristique> caracs;
	
	protected Rarete rarete;

	protected List<Slot> slots;
	
	public Item() {
		this.id = new ObjectId().toString();
	}
	
	public Item (ItemType type, String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis, List<Slot> slots){
		this.itemType = type;
		this.id = new ObjectId().toString();
		this.res = resTotale;
		this.resTotale = resTotale;
		this.nom = nom;
		this.caracs = caracs;
		this.rarete = rarete;
		this.niveauRequis = niveauRequis;
		this.slots = slots;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", resTotale=" + resTotale + ", res=" + res + ", niveauRequis=" + niveauRequis
				+ ", nom=" + nom + ", itemType=" + itemType + ", caracs=" + caracs + ", rarete=" + rarete + "]";
	}
	
	// Tous les getter et setter

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getResTotale() {
		return resTotale;
	}

	public void setResTotale(int resTotale) {
		this.resTotale = resTotale;
		this.res = resTotale;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType type) {
		this.itemType = type;
	}
	
	public int getNiveauRequit() {
		return niveauRequis;
	}

	public void setNiveauRequit(int niveauRequit) {
		this.niveauRequis = niveauRequit;
	}

	public Rarete getRarete() {
		return rarete;
	}

	public void setRarete(Rarete rarete) {
		this.rarete = rarete;
	}

	public int getNiveauRequis() {
		return niveauRequis;
	}

	public void setNiveauRequis(int niveauRequis) {
		this.niveauRequis = niveauRequis;
	}

	public List<Caracteristique> getCaracs() {
		return caracs;
	}

	public void setCaracs(List<Caracteristique> caracs) {
		this.caracs = caracs;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public int lowerRes(){
		if (this.res>0)
			this.res--;
		return this.res;
	}

}
