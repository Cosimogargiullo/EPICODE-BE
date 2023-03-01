package it.epicode.gestione.incendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.epicode.be.gestioneincendi.model.Sonda;

@SpringBootApplication
public class GestioneIncendiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiiApplication.class, args);
		Sonda s = new Sonda();
		System.out.println(s);
	}

}
