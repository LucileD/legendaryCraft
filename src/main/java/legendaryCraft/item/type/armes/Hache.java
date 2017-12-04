package legendaryCraft.item.type.armes;

import java.util.List;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.Rarete;

public class Hache extends Arme {

	public Hache(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis) {
		super(nom, resTotale, caracs, rarete, niveauRequis, ArmeType.UNE_MAIN);
	}

}
