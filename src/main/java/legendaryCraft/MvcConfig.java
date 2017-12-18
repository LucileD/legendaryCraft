package legendaryCraft;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/app/login").setViewName("login");
        registry.addViewController("/").setViewName("joueur");
        registry.addViewController("/app/items").setViewName("items");
        registry.addViewController("/app/item").setViewName("item");
        registry.addViewController("/app/joueur").setViewName("joueur");
    }

}
