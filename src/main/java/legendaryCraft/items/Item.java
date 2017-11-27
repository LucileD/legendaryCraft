package legendaryCraft.items;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Item {
	
	@Id
	protected String id;
	
	protected int resTotale;
	
	protected int res ;
	
	protected int niveauRequit;
	
	protected String nom;
	
	protected String type;
	
	protected List<Caracteristique> caracs;
	
	protected Rarete rerate;
	
	public Item() {
		this.id = new ObjectId().toString();
	}
	
	public Item (String type, String nom, int resTotale){
		this.type = type;
		this.id = new ObjectId().toString();
		this.res = resTotale;
		this.resTotale = resTotale;
		this.nom = nom;
	}


	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getResTotale() {
		return resTotale;
	}


	public String getId() {
		return id;
	}

	public void setResTotale(int resTotale) {
		this.resTotale = resTotale;
		this.res = resTotale;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int lowerRes(){
		if (this.res>0)
			this.res--;
		return this.res;
	}
	
	

}
