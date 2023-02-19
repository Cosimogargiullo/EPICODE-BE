package it.epicode.be.week6.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import it.epicode.be.week6.project.model.Utente;
import it.epicode.be.week6.project.service.UtenteService;

@Component
public class GestioneDispositiviRunner implements CommandLineRunner {

	@Autowired
	UtenteService us;
	
	@Override
	public void run(String... args) throws Exception {

		Utente u1 = new Utente();
		us.save(u1);
		
	}

}
