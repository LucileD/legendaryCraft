package legendaryCraft.personnage;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import legendaryCraft.item.type.*;
import legendaryCraft.item.type.armes.Arme;

@Document(collection="personnages")
public class Personnage {
	
	@Id
	protected String id;
	
	protected String nom;
	
	@DBRef
	protected Joueur joueur;
	
	protected int niveau;
	
	protected Ceinture ceinture;
	
	protected Armure armure;
	
	protected Bottes bottes;
	
	protected Arme arme;
	
	protected Bouclier bouclier;
	
	protected Anneau anneauDroit;
	
	protected Anneau anneauGauche;
	
	protected Casque casque;
	
	protected Pantalon pantalon;
	
	protected Amulette amulette;

	
	
	public Personnage(String nom, Joueur joueur, int niveau, Ceinture ceinture, Armure armure, Bottes bottes, Arme arme,
			Bouclier bouclier, Anneau anneauDroit, Anneau anneauGauche, Casque casque, Pantalon pantalon,
			Amulette amulette) {
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

	public Ceinture getCeinture() {
		return ceinture;
	}

	public void setCeinture(Ceinture ceinture) {
		this.ceinture = ceinture;
	}

	public Armure getArmure() {
		return armure;
	}

	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	public Bottes getbottes() {
		return bottes;
	}

	public void setbottes(Bottes bottes) {
		this.bottes = bottes;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Bouclier getBouclier() {
		return bouclier;
	}

	public void setBouclier(Bouclier bouclier) {
		this.bouclier = bouclier;this.id = new ObjectId().toString();
	}

	public Anneau getAnneauDroit() {
		return anneauDroit;
	}

	public void setAnneauDroit(Anneau anneauDroit) {
		this.anneauDroit = anneauDroit;
	}

	public Anneau getAnneauGauche() {
		return anneauGauche;
	}

	public void setAnneauGauche(Anneau anneauGauche) {
		this.anneauGauche = anneauGauche;
	}

	public Casque getCasque() {
		return casque;
	}

	public void setCasque(Casque casque) {
		this.casque = casque;
	}

	public Pantalon getPantalon() {
		return pantalon;
	}

	public void setPantalon(Pantalon pantalon) {
		this.pantalon = pantalon;
	}

	public Amulette getAmulette() {
		return amulette;
	}

	public void setAmulette(Amulette amulette) {
		this.amulette = amulette;
	}
	
	
	
	
	
	

}
