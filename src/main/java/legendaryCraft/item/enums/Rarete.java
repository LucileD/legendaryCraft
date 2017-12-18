package legendaryCraft.item.enums;

public enum Rarete {
	LEGENDARY("Legendaire"),
	RARE("Rare"),
	COMMON("Commun");
	
	private String valeur;
	
	Rarete(String valeur) {
		this.valeur = valeur;
	}
	
	@Override
	public String toString() {
		return this.valeur;
	}
}
