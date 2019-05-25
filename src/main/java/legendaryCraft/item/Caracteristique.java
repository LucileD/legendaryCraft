package legendaryCraft.item;

public class Caracteristique {
	
	private int valeur;
	private CaracteristiqueIntitule nom;

	public Caracteristique (CaracteristiqueIntitule nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public int getValeur() {
		return this.valeur;
	}

	public CaracteristiqueIntitule getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return this.nom + "(+" + this.valeur + ")";
	}
	
}
