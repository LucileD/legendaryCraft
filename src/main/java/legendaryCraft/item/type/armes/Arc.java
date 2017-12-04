package legendaryCraft.item.type.armes;

import java.util.List;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.Rarete;

public class Arc extends Arme {

	public Arc(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis) {
		super(nom, resTotale, caracs, rarete, niveauRequis, ArmeType.DEUX_MAINS);
	}

}
