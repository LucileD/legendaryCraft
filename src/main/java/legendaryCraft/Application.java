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

import legendaryCraft.item.ArmeRepository;
import legendaryCraft.item.Caracteristique;
import legendaryCraft.item.CaracteristiqueIntitule;
import legendaryCraft.item.Item;
import legendaryCraft.item.ItemRepository;
import legendaryCraft.item.enums.ArmeType;
import legendaryCraft.item.enums.ItemType;
import legendaryCraft.item.enums.Maniement;
import legendaryCraft.item.enums.Rarete;
import legendaryCraft.item.type.Armure;
import legendaryCraft.item.type.Casque;
import legendaryCraft.item.type.armes.Arme;
import legendaryCraft.item.type.armes.Epee;
import legendaryCraft.item.type.armes.Masse;
import legendaryCraft.notification.NotificationDurability;
import legendaryCraft.personnage.Joueur;
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
    public CommandLineRunner demo(ItemRepository itemRepository, ArmeRepository armeRepository, PersonnageRepository personnageRepository){
    	ArrayList<Caracteristique> cars = new ArrayList<Caracteristique>();
    	
    	Caracteristique res = new Caracteristique(CaracteristiqueIntitule.RESISTANCE, 10);
    	cars.add(res);
    	
    	Casque c = new Casque("Heaume de chevalier", 40, cars, Rarete.COMMON, 1);
    	Armure a = new Armure("Armure de basse qualité magique", 45, cars, Rarete.RARE, 1);
    	cars.remove(res);
    	
    	
    	Caracteristique deg = new Caracteristique(CaracteristiqueIntitule.DOMMAGE, 15);
    	cars.add(deg);
    	
    	Epee e = new Epee("Lame de Duncan", 50, cars, Rarete.RARE, 1, Maniement.UNE_MAIN);
    	Masse m = new Masse("Masse de son père", 20, cars, Rarete.COMMON, 1);
    	
    	
    	itemRepository.save(c);
    	itemRepository.save(a);
    	armeRepository.save(e);
    	armeRepository.save(m);
    	
//    	repository.save(new Item("boucle d'oreilles","nomb",10));
//    	repository.save(new Item("ceinture","c1",20));
//    	repository.save(new Item("épée","e1",100));

    	personnageRepository.save(new Personnage("perso1", new Joueur(), 2, null, null, null, null, null, null, null, null, null, null));
    	personnageRepository.save(new Personnage("perso2", new Joueur(), 8, null, null, null, null, null, null, null, null, null, null));
    	
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
	    	
	    	log.info("Récupérer les armes");
	    	log.info("--------------------------------");
	    	for (Arme arme : armeRepository.findAll()) {
	    		log.info(arme.toString());
	    	}
	    	
	    	log.info("Récupérer les armes à une main");
	    	log.info("--------------------------------");
	    	for (Arme arme : armeRepository.findByManiement(Maniement.UNE_MAIN)) {
	    		log.info(arme.toString());
	    	}
	    	
	    	log.info("Récupérer les épées");
	    	log.info("--------------------------------");
	    	for (Arme arme : armeRepository.findByArmeType(ArmeType.EPEE)) {
	    		log.info(arme.toString());
	    	}
	    	
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
