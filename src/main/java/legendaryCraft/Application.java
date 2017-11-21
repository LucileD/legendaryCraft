package legendaryCraft;



import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import legendaryCraft.items.Item;
import legendaryCraft.items.ItemRepository;

@SpringBootApplication
@EnableMongoRepositories
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(ItemRepository repository){
    	repository.save(new Item("boucle d'oreilles","nomb",10));
    	repository.save(new Item("ceinture","c1",20));
    	repository.save(new Item("épée","e1",100));
    	return args ->{

	    	log.info("Personnes trouvé avec findAll():");
	    	log.info("--------------------------------");
	    	for (Item item : repository.findAll()){
	    		log.info(item.toString());
	    	}
	    };
    }
}
