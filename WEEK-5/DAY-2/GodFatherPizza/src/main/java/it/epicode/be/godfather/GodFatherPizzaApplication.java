package it.epicode.be.godfather;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.epicode.be.godfather.model.Ordine;
import it.epicode.be.godfather.model.StatoOrdine;
import it.epicode.be.godfather.model.Tavolo;

@SpringBootApplication
public class GodFatherPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodFatherPizzaApplication.class, args);

		GestioneMenu menu = new GestioneMenu();
		menu.stampaMenu();
		menu.testTopping();
		
		
		GestioneOrdini ordine = new GestioneOrdini();
		ordine.stampaOrdini();
//		ESERCIZIO ORDINI
//		Tavolo t1 = new Tavolo();
//		Ordine ordine = new Ordine(1, t1, 3);

	}

}
