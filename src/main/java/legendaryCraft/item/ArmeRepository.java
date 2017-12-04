package legendaryCraft.item;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import legendaryCraft.item.enums.ArmeType;
import legendaryCraft.item.enums.Maniement;
import legendaryCraft.item.type.armes.Arme;

@Repository
public interface ArmeRepository extends MongoRepository<Arme, String> {
	
	public Arme findById(String id);
	
	public Arme findByNom(String nom);
	
	public List<Arme> findByArmeType(ArmeType armeType);
	
	public List<Arme> findByManiement(Maniement maniement);
}