package it.epicode.be.week6.project.configuration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import it.epicode.be.week6.project.model.Utente;

@Configuration
public class Beans {

	@Bean
	@Scope("prototype")
	public Utente utente(String username, String nome, String cognome, String email) {
		return Utente.builder()
				.username(username)
				.nome(nome)
				.cognome(cognome)
				.email(email)
				.build();
	}
	
//	@Bean
//	@Scope("prototype")
//	public Role role(RoleType rt) {
//		return Role.builder()
//				.type(rt)
//				.build();
//	}
	
}
