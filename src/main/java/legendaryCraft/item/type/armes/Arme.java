package legendaryCraft.item.type.armes;

import java.util.List;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.Item;
import legendaryCraft.item.ItemType;
import legendaryCraft.item.Rarete;

public abstract class Arme extends Item {

	protected ArmeType armeType;
	
	public Arme(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis, ArmeType armeType) {
		super(ItemType.ARME, nom, resTotale, caracs, rarete, niveauRequis);
		this.armeType = armeType;
	}
	
}
