package it.epicode.week2day5;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
//		INSTANCES ------------------------------------------------
//		Archive
		Archivio a1 = new Archivio();

//		Array List of elements 
		ArrayList<Elemento> elements = new ArrayList<Elemento>(
			Arrays.asList(
				new Libro("1234", "Twilight", LocalDate.of(2021, 1, 2), 240, "Stephenie Meyer", "Romantico"),
				new Libro("5432", "Pinocchio", LocalDate.of(2022, 1, 2), 180, "Carlo Collodi", "Bambini"),
				new Rivista("4321", "Uomini e Donne", LocalDate.of(2023, 1, 2), 20, Periodicita.SETTIMANALE),
				new Rivista("4578", "Chi", LocalDate.of(2022, 1, 2), 20, Periodicita.MENSILE),
				new Libro("1783", "After", LocalDate.of(2019, 1, 2), 310, "Anna Todd", "Romantico"),
				new Rivista("4321", "Cioe", LocalDate.of(2022, 1, 2), 22, Periodicita.SEMESTRALE)
			)
		);
				
//		ADDING ------------------------------------------------
//		Adding an arrayList of elements to the Archive
		a1.aggiungiElemento(elements);
//		Adding a single elements to the Archive
		a1.aggiungiElemento(new Libro("3241", "Joke", LocalDate.of(2021, 1, 2), 190, "Rodolfo", "Romantico"));
		
//		Archive print before
		System.out.printf("Stato iniziale dell' archivio:%n%n");
		a1.printArchivio();
		
//		REMOVE AND RESEARCH BY ------------------------------------------------
		a1.rimuoviIsbn("5432");
		System.out.printf("%nStato Attuale dell' archivio:%n%n");
		a1.printArchivio();
		
		a1.ricercaIsbn("1234");
		a1.ricercaAnno(2022);
		a1.ricercaAutore("Rodolfo");
		a1.ricerca(Tipo.TITOLO, "After");
		
//		SAVE ON DISC ------------------------------------------------
//		Write on disc
//		a1.scriviFile("prova.txt", new Libro("1234", "Libro-1", LocalDate.of(2021, 1, 2), 200, "Cosimo", "Azione"));
		a1.scriviFile("Archivio.txt", a1);
		
//		Read from disc
		System.out.println( "Avvio lettura dal file:" );
		try {
			a1.leggiFile("Archivio.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
