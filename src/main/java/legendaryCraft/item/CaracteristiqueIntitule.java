package legendaryCraft.item;

public enum CaracteristiqueIntitule {

	DOMMAGE ("Dommage"),
	RESISTANCE ("Résistance"),
	FORCE ("Force"),
	INTELLIGENCE ("Intélligence"),
	CHANCE ("Chance"),
	AGILITE ("Agilité"),
	VIE ("Vie"),
	MANA("Mana"),
	ENDURANCE ("Endurance"),
	VITESSE_ATTAQUE ("Vitesse d'attaque");
	
	private String nom;

	CaracteristiqueIntitule (String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}
