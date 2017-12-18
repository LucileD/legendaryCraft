package legendaryCraft.item.enums;

/**
 * Type d'item correspondant aux emplacements disponible sur les personnages (pas de détail concernant le type d'arme)
 * @author ongenae
 *
 */
public enum ItemType {
	CASQUE("Casque", false),
	BOUCLIER("Bouclier", false),
	ARMURE("Armure", false),
	CEINTURE("Ceinture", false),
	PANTALON("Pantalon", false),
	BOTTES("Bottes", false),
	ANNEAU("Anneau", false),
	AMULETTE("Amulette", false),
	EPEE("Epee", true),
	ARC("Arc", true),
	BATON("Baton", true),
	DAGUE("Dague", true),
	HACHE("Hache", true),
	MASSE("Masse", true);
	
	private String nom;
	private boolean estArme;

	ItemType(String nom, boolean estArme) {
		this.nom = nom;
		this.estArme = estArme;
	}
	
	public String getNom() {
		return nom;
	}
	
	public boolean getEstArme() {
		return estArme;
	}
	
	@Override
	public String toString() {
		return nom;
	}
};
