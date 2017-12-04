package legendaryCraft.item.type;

import java.util.List;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.Item;
import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Rarete;

public class Pantalon extends Item {

	public Pantalon(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis) {
		super(ItemType.PANTALON, nom, resTotale, caracs, rarete, niveauRequis);
	}
	
}
