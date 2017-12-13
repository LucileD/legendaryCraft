package legendaryCraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import legendaryCraft.personnage.Joueur;
import legendaryCraft.personnage.JoueurRepository;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
	@Autowired
    JoueurRepository joueurRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
    	return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		        Joueur j = joueurRepository.findByLogin("test");
		        User res = new User(j.getLogin(), j.getMdp(), AuthorityUtils.createAuthorityList("USER", "write"));
				return res;
			}
    	};        
    }
	
}



