package legendaryCraft.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Rarete;
import legendaryCraft.personnage.Joueur;
import legendaryCraft.personnage.Personnage;

public class CraftUtils {

	private final static int chanceToCraftLegendary = 5;
	private final static int chanceToCraftRare = 25;
	
	private final static int statsLegendary = 100;
	private final static int statsRare = 40;
	private final static int statsCommon = 15;
	
	private final static String[] legendaryNames = {"d'Ormus", "d'Arkaine", "de l'Exécuteur", "d'Avalon", "du Sorcier Gris", "d'Astora", "de la Prétresse", "de l'Errant"};
	private final static String[] rareNames = {"magique", "de valeur", "du chevalier", "du mage", "du voleur", "de qualité"};
	private final static String[] commonNames = {"de mauvaise facture", "de fer", "d'acier", "d'écuyer", "d'apprenti", "de marchand"};
	
	public static Item craftItem(Personnage personnage) {
		/* variables pour la génération */
		int nbStats;
		int valStats;
		CaracteristiqueIntitule[] caracsPossibles = CaracteristiqueIntitule.values();
		Random randomGen = new Random();
		
		/* variables de l'item */
		ItemType type;
		String nom;
		List<Caracteristique> caracs = new ArrayList<Caracteristique>();
		Rarete rarete;
		int niveauRequis = randomGen.nextInt(100);
		boolean aDeuxMains = false;
	
		
		// génération du type d'item
		type = ItemType.values()[randomGen.nextInt(14)];
		nom = type.getNom() + " ";
		
		// déterminer si l'item est une arme à une main ou à deux mains si nécessaire
		if (type.getEstArme()) {
			if (type.getNom() == "Arc" | type.getNom() == "Baton") {
				// forcément à deux mains
				aDeuxMains = true;
			} else if (type.getNom() != "Dague" | type.getNom() != "Masse") {
				// si l'arme n'est pas une arme à une main forcément alors elle peut être les deux, on randomise donc le choix
				aDeuxMains = randomGen.nextBoolean();
			}
		}
		// génération de la rareté et du nom de l'item
		int r = randomGen.nextInt(100);
		if (r <= chanceToCraftLegendary) {
			rarete = Rarete.LEGENDARY;
			nbStats = 3;
			valStats = statsLegendary;
			nom += legendaryNames[randomGen.nextInt(legendaryNames.length - 1)];
		} else if (r <= chanceToCraftRare) {
			rarete = Rarete.RARE;
			nbStats = 2;
			valStats = statsRare;
			nom += rareNames[randomGen.nextInt(rareNames.length - 1)];
		} else {
			rarete = Rarete.COMMON;
			nbStats = 1;
			valStats = statsCommon;
			nom += commonNames[randomGen.nextInt(commonNames.length - 1)];
		}
		
		// génération des stats de l'item
		// mémo : [0] -> dommage ; [1] -> resistance
		if (type.getEstArme()) {
			caracs.add(new Caracteristique(caracsPossibles[0], valStats));
		} else {
			caracs.add(new Caracteristique(caracsPossibles[1], valStats));
		}
		
		int[] caracsChoisies = randomGen.ints(2, caracsPossibles.length).distinct().limit(nbStats).toArray();
		for (int i : caracsChoisies) {
			System.out.println("caracs choisies : " + i);
			caracs.add(new Caracteristique(caracsPossibles[i], valStats));
		}
		
		//création de l'item avec toutes les données générées au dessus
		return new Item(type, nom, valStats, caracs, rarete, niveauRequis, aDeuxMains, personnage);
	}
	
}
