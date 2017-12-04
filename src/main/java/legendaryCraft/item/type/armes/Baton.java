package legendaryCraft.item.type.armes;

import java.util.List;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.enums.ArmeType;
import legendaryCraft.item.enums.Maniement;
import legendaryCraft.item.enums.Rarete;

public class Baton extends Arme {

	public Baton(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis) {
		super(nom, resTotale, caracs, rarete, niveauRequis, ArmeType.BATON, Maniement.DEUX_MAINS);
	}

}
