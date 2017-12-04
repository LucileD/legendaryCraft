package legendaryCraft.item.type.armes;

import java.util.List;

import legendaryCraft.item.Caracteristique;

import legendaryCraft.item.enums.ArmeType;
import legendaryCraft.item.enums.Maniement;
import legendaryCraft.item.enums.Rarete;

public class Masse extends Arme {

	public Masse(String nom, int resTotale, List<Caracteristique> caracs, Rarete rarete, int niveauRequis) {
		super(nom, resTotale, caracs, rarete, niveauRequis, ArmeType.MASSE, Maniement.DEUX_MAINS);
	}

}
