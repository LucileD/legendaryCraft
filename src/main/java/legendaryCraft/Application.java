package legendaryCraft;



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

import legendaryCraft.item.Item;
import legendaryCraft.item.ItemRepository;
import legendaryCraft.notification.NotificationDurability;

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
    public CommandLineRunner demo(ItemRepository repository){
//    	repository.save(new Item("boucle d'oreilles","nomb",10));
//    	repository.save(new Item("ceinture","c1",20));
//    	repository.save(new Item("épée","e1",100));
    	return args ->{

	    	log.info("Personnes trouvé avec findAll():");
	    	log.info("--------------------------------");
	    	for (Item item : repository.findAll()){
	    		log.info(item.toString());
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
