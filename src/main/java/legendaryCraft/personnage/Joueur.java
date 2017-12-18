package legendaryCraft.personnage;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Joueur {
	
	protected String pseudo;
	
	protected String mdp;
	
	protected List<Personnage> personnages;
	
	@Id
	protected String id;
	
	public Joueur () {
		this.id = new ObjectId().toString();
	}
	

}
