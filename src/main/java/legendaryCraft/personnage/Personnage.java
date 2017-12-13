package legendaryCraft.personnage;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import legendaryCraft.item.Item;

@Document(collection="personnages")
public class Personnage {
	
	@Id
	protected String id;
	
	protected String nom;
	
	@DBRef
	protected Joueur joueur;
	
	protected int niveau;
	
	protected Item ceinture;
	
	protected Item armure;
	
	protected Item bottes;
	
	protected Item arme;
	
	protected Item bouclier;
	
	protected Item anneauDroit;
	
	protected Item anneauGauche;
	
	protected Item casque;
	
	protected Item pantalon;
	
	protected Item amulette;

	
	
	public Personnage(String nom, Joueur joueur, int niveau, Item ceinture, Item armure, Item bottes, Item arme,
			Item bouclier, Item anneauDroit, Item anneauGauche, Item casque, Item pantalon, Item amulette) {
		this.id = new ObjectId().toString();
		this.nom = nom;
		this.joueur = joueur;
		this.niveau = niveau;
		this.ceinture = ceinture;
		this.armure = armure;
		this.bottes = bottes;
		this.arme = arme;
		this.bouclier = bouclier;
		this.anneauDroit = anneauDroit;
		this.anneauGauche = anneauGauche;
		this.casque = casque;
		this.pantalon = pantalon;
		this.amulette = amulette;
	}




	public Personnage() {
		this.id = new ObjectId().toString();
	}

	
	
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getNom() {
		return nom;
	}





	public void setNom(String nom) {
		this.nom = nom;
	}





	public Joueur getJoueur() {
		return joueur;
	}





	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}





	public int getNiveau() {
		return niveau;
	}





	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}





	public Item getCeinture() {
		return ceinture;
	}





	public void setCeinture(Item ceinture) {
		this.ceinture = ceinture;
	}





	public Item getArmure() {
		return armure;
	}





	public void setArmure(Item armure) {
		this.armure = armure;
	}





	public Item getBottes() {
		return bottes;
	}





	public void setBottes(Item bottes) {
		this.bottes = bottes;
	}





	public Item getArme() {
		return arme;
	}





	public void setArme(Item arme) {
		this.arme = arme;
	}





	public Item getBouclier() {
		return bouclier;
	}





	public void setBouclier(Item bouclier) {
		this.bouclier = bouclier;
	}





	public Item getAnneauDroit() {
		return anneauDroit;
	}





	public void setAnneauDroit(Item anneauDroit) {
		this.anneauDroit = anneauDroit;
	}





	public Item getAnneauGauche() {
		return anneauGauche;
	}





	public void setAnneauGauche(Item anneauGauche) {
		this.anneauGauche = anneauGauche;
	}





	public Item getCasque() {
		return casque;
	}





	public void setCasque(Item casque) {
		this.casque = casque;
	}





	public Item getPantalon() {
		return pantalon;
	}





	public void setPantalon(Item pantalon) {
		this.pantalon = pantalon;
	}





	public Item getAmulette() {
		return amulette;
	}





	public void setAmulette(Item amulette) {
		this.amulette = amulette;
	}





	

	
	

}
