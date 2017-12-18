package legendaryCraft;



import java.util.ArrayList;

import javax.jms.ConnectionFactory;

import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.jms.support.converter.MessageConverter;

import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.CaracteristiqueIntitule;
import legendaryCraft.item.Item;
import legendaryCraft.item.ItemRepository;
import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Rarete;
import legendaryCraft.notification.NotificationDurability;
import legendaryCraft.personnage.Joueur;
import legendaryCraft.personnage.JoueurRepository;
import legendaryCraft.personnage.Personnage;
import legendaryCraft.personnage.PersonnageRepository;

@SpringBootApplication
@EnableMongoRepositories
@EnableJms
@EnableScheduling
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	

    public static void main(String[] args) {
    	 // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        for ( int i=0; i< 5; i++){
        	jmsTemplate.convertAndSend("mailbox", new NotificationDurability());
        }

        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(ItemRepository itemRepository, PersonnageRepository personnageRepository, JoueurRepository joueurRepository){
//    	armeRepository.save(e);
//    	armeRepository.save(m);
    	
//    	repository.save(new Item("boucle d'oreilles","nomb",10));
//    	repository.save(new Item("ceinture","c1",20));
//    	repository.save(new Item("épée","e1",100));

//    	personnageRepository.save(new Personnage("perso1", new Joueur(), 2, null, null, null, null, null, null, null, null, null, null));
//    	personnageRepository.save(new Personnage("perso2", new Joueur(), 8, null, null, null, null, null, null, null, null, null, null));
   
    	Joueur j1 = new Joueur("TrucMuche","truc","muche");
    	Joueur j2 = new Joueur("Avast","Dorian","mdp");
    	joueurRepository.save(j1);
    	joueurRepository.save(j2);
    	
    	Personnage truc = new Personnage("Truc", j1, 90);
    	Personnage muche = new Personnage("Muche", j1, 2);
    	Personnage zoe = new Personnage("Zoé", j2, 2);
    	personnageRepository.save(truc);
    	personnageRepository.save(muche);
    	personnageRepository.save(zoe);
    	
    	ArrayList<Caracteristique> cars = new ArrayList<Caracteristique>();
    	
    	Caracteristique res = new Caracteristique(CaracteristiqueIntitule.RESISTANCE, 10);
    	cars.add(res);
    	
    	Item casque = new Item(ItemType.CASQUE, "Heaume de chevalier", 40, cars, Rarete.COMMON, 1, false, truc);
    	
    	Item armure = new Item(ItemType.ARMURE, "Armure de basse qualité magique", 45, cars, Rarete.RARE, 10, false, truc);
    	
    	Item bouclier = new Item(ItemType.BOUCLIER, "Bouclier de bois", 10, cars, Rarete.COMMON, 1, false, truc);
    	
    	cars.remove(res);
    	
    	Caracteristique deg = new Caracteristique(CaracteristiqueIntitule.DOMMAGE, 15);
    	cars.add(deg);
    	
    	Item epee = new Item(ItemType.EPEE, "Lame de Duncan", 50, cars, Rarete.RARE, 1, true, truc);
    	Item epeepetite = new Item(ItemType.EPEE, "mini lame des eaux", 2, cars, Rarete.COMMON, 1, false, truc);
    	
    	Item masse = new Item(ItemType.MASSE, "Masse de son père", 20, cars, Rarete.COMMON, 99, false, truc);
    	
    	itemRepository.save(epeepetite);
    	itemRepository.save(casque);
    	itemRepository.save(armure);
    	itemRepository.save(epee);
    	itemRepository.save(masse);
    	itemRepository.save(bouclier);
    	
    	return args ->{

	    	log.info("items trouvés avec findAll():");
	    	log.info("--------------------------------");
	    	for (Item item : itemRepository.findAll()){
	    		log.info(item.toString());
	    	}
	    	
	    	log.info("Récupérer un item de rarete 'rare'");
	    	log.info("--------------------------------");
	    	for (Item item : itemRepository.findByRarete(Rarete.RARE)) {
	    		log.info(item.toString());
	    	}
	    	
	    	log.info("Récupérer les epees");
	    	log.info("--------------------------------");
	    	for (Item arme : itemRepository.findByItemType(ItemType.EPEE)) {
	    		log.info(arme.toString());
	    	}
	    	
	    	//ne marche pas, on verra plus tard
//	    	log.info("Récupérer les items à une main");
//	    	log.info("--------------------------------");
//	    	for (Item arme : itemRepository.findBySlots(slots)) {
//	    		log.info(arme.toString());
//	    	}
	    	
//	    	log.info("Récupérer les items à deux mains");
//	    	log.info("--------------------------------");
//	    	slots.clear();
//	    	slots.add(Slot.MAIN_GAUCHE);
//	    	slots.add(Slot.MAIN_DROITE);
//	    	for (Item arme : itemRepository.findBySlots(slots)) {
//	    		log.info(arme.toString());
//	    	}
	    	
	    };
    }
    
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }
    
    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
    
    
    
}
