package legendaryCraft.item.type.armes;

import java.util.List;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.Item;
import legendaryCraft.item.enums.ArmeType;
import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Maniement;
import legendaryCraft.item.enums.Rarete;

public abstract class Arme extends Item {

	protected Maniement maniement;
	
	protected ArmeType armeType;
	
	public Arme(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis, ArmeType armeType, Maniement mt) {
		super(ItemType.ARME, nom, resTotale, caracs, rarete, niveauRequis);
		this.armeType = armeType;
		this.maniement = mt;
	}

	public Maniement getManiement() {
		return maniement;
	}

	public void setManiement(Maniement maniementType) {
		this.maniement = maniementType;
	}

	public ArmeType getArmeType() {
		return armeType;
	}

	public void setArmeType(ArmeType armeType) {
		this.armeType = armeType;
	}

	
	
}
