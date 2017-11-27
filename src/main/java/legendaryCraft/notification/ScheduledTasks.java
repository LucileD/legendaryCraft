package legendaryCraft.notification;


import java.awt.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import legendaryCraft.item.Item;
import legendaryCraft.item.ItemRepository;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	private ItemRepository repository;
	
	@Scheduled(fixedRate = 5000)
	public void lowerDurability() {
		log.info("Diminution de la durabilité de chaque item de chaque utilisateur");
		// récupérer les items de chaque user et diminuer la résistance
		ArrayList<Item> items = (ArrayList<Item>) repository.findAll();
		for (Item i : items) {
			int v = i.lowerRes();
			if (v == 0) {
				// envoyer notif
				log.info("Item " + i.getNom() + " resistance at 0.");
			}
		}
		repository.save(items);
	}
}
