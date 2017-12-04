package legendaryCraft.personnage;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Joueur {
	
	protected String pseudo;
	
	protected String mdp;
	
	@Id
	protected String id;
	
	public Joueur () {
		this.id = new ObjectId().toString();
	}
	

}
