package it.epicode.be.week6Day4.configuration;

import java.util.HashSet;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import it.epicode.be.week6Day4.services.RoleService;
import it.epicode.be.week6Day4.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserService uService;
	
	@Autowired
	public RoleService rService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * gestisci le autorizzazioni
		 * permetti l'accesso a / e /page1 a tutti
		 * mentre a tutte le altre imponi autorizzazione e redirect sulla pagina
		 * di login
		 */
//		http
//			.authorizeRequests()					
//				.antMatchers("/", "/page1")
//				.permitAll()
//			.anyRequest()
//				.authenticated()
//			.and()
//			.formLogin()
//				.successForwardUrl("/login_success")
//			.and()
//			.logout()
//			.and()
//			.csrf()
//				.disable();
//	}
	
	// v1 hardcoded
	/*
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("student").password( passwordEncoder().encode("mela") )
			.roles("ADMIN");
	}
	*/
	
	// v2 get from db
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		Optional<User> authUserObj = dao.getUserById(1);
//		User authUser = authUserObj.get();
//		String role = "USER";
//		Set<Role> roles = authUser.getRoles();
//		
//		for( Role r : roles ) {
//			if( r.getType().toString().contains("ADMIN") ) {
//				role = "ADMIN";
//				break;
//			}
//		}
//		
//		auth.inMemoryAuthentication()
//			.withUser( authUser.getUsername() ).password( passwordEncoder().encode( authUser.getPassword() ) )
//			.roles(role);
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
	}
}
