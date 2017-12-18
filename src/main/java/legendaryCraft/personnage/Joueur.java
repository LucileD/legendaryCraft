package legendaryCraft.personnage;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Joueur {
	
	protected String pseudo;
	
	protected String login;
	
	protected String mdp;
	
	protected List<Personnage> personnages;
	
	@Id
	protected String id;
	
	public Joueur () {
		this.id = new ObjectId().toString();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
