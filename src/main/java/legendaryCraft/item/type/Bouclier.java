package legendaryCraft.item.type;

import java.util.List;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.Item;
import legendaryCraft.item.ItemType;
import legendaryCraft.item.Rarete;

public class Bouclier extends Item {

	public Bouclier(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis) {
		super(ItemType.BOUCLIER, nom, resTotale, caracs, rarete, niveauRequis);
	}
	
}
