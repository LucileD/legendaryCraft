package legendaryCraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
	    .authorizeRequests()
        	.antMatchers("/index.html").permitAll()
		    .anyRequest().authenticated()
		    .and()
	    .formLogin()
		    .loginPage("/app/login")
		    .permitAll()
		    .and()
		 .logout()    //logout configuration
			.logoutSuccessUrl("/index.html");
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("username").password("password").roles("USER");
        auth.inMemoryAuthentication()
        	.withUser("Dorian").password("mdp").roles("USER");
        auth.inMemoryAuthentication()
    		.withUser("truc").password("muche").roles("USER");
    }

}
