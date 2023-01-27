package it.epicode.week3day5.gestioneCatalogo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import it.epicode.week3day5.models.Archivio;
import it.epicode.week3day5.models.Elemento;
import it.epicode.week3day5.models.Libro;
import it.epicode.week3day5.models.Periodicita;
import it.epicode.week3day5.models.Prestito;
import it.epicode.week3day5.models.Rivista;
import it.epicode.week3day5.models.Tipo;
import it.epicode.week3day5.models.Utente;
import it.epicode.week3day5.models.dao.ElementoDAO;

public class Main {

	public static void main(String[] args) {
		String s = System.lineSeparator();
		
//		ISTANZE ELEMENTO
		Elemento e1 = new Libro("1234", "Twilight", LocalDate.of(2021, 1, 2), 240, "Stephenie Meyer", "Romantico");
		Elemento e2 = new Libro("5432", "Pinocchio", LocalDate.of(2022, 1, 2), 180, "Carlo Collodi", "Bambini");
		Elemento e3 = new Rivista("4321", "Uomini e Donne", LocalDate.of(2022, 1, 2), 20, Periodicita.SETTIMANALE);
		Elemento e4 = new Rivista("6789", "Chi", LocalDate.of(2022, 1, 2), 20, Periodicita.MENSILE);
		
//		SAVE ELEMENTO
		ElementoDAO.saveElement(e1);
		ElementoDAO.saveElement(e2);
		ElementoDAO.saveElement(e3);
		ElementoDAO.saveElement(e4);
		System.err.println(s);
		
//		METODI DAO
		ElementoDAO.deleteByISBN("6789");
		System.err.println(s);
		ElementoDAO.getByISBN("5432");
		System.err.println(s);
		ElementoDAO.getByAnno(2022);
		System.err.println(s);
		ElementoDAO.getByAutore("Carlo Collodi");
		System.err.println(s);
		ElementoDAO.getByTitolo("Pi");
		System.err.println(s);
		
//		ISTANZA UTENTE
		Utente u1 = new Utente("Riccardo", "Sennati", LocalDate.of(2002, 1, 4), 123);
		Utente u2 = new Utente("Laura", "Rose", LocalDate.of(2001, 10, 6), 456);
		
//		SAVE UTENTE
		ElementoDAO.saveElement(u1);
		ElementoDAO.saveElement(u2);
		
//		ISTANZA PRESTITO
		Prestito p1 = new Prestito(u1, e1, LocalDate.of(2023, 1, 25), LocalDate.of(2023, 6, 4));
		Prestito p2 = new Prestito(u2, e2, LocalDate.of(2023, 1, 30), null);
		Prestito p3 = new Prestito(u1, e1, LocalDate.of(2023, 1, 25), LocalDate.of(2023, 6, 4));
		Prestito p4 = new Prestito(u2, e3, LocalDate.of(2022, 1, 30), null);
		
//		SAVE PRESTITO
		ElementoDAO.saveElement(p1);
		ElementoDAO.saveElement(p2);
		ElementoDAO.saveElement(p3);
		ElementoDAO.saveElement(p4);
		
//		METODI DAO
		System.err.println(s);
		ElementoDAO.getElementiPrestati(456);
		System.err.println(s);
		ElementoDAO.getPrestitiScaduti();
		
//		ESERCIZIO ORIGINARIO WEEK 2
////		INSTANCES ------------------------------------------------
////		Archive
//		Archivio a1 = new Archivio();
//
////		Array List of elements 
//		ArrayList<Elemento> elements = new ArrayList<Elemento>(
//			Arrays.asList(
//				new Libro("1234", "Twilight", LocalDate.of(2021, 1, 2), 240, "Stephenie Meyer", "Romantico"),
//				new Libro("5432", "Pinocchio", LocalDate.of(2022, 1, 2), 180, "Carlo Collodi", "Bambini"),
//				new Rivista("4321", "Uomini e Donne", LocalDate.of(2023, 1, 2), 20, Periodicita.SETTIMANALE),
//				new Rivista("4578", "Chi", LocalDate.of(2022, 1, 2), 20, Periodicita.MENSILE),
//				new Libro("1783", "After", LocalDate.of(2019, 1, 2), 310, "Anna Todd", "Romantico"),
//				new Rivista("4321", "Cioe", LocalDate.of(2022, 1, 2), 22, Periodicita.SEMESTRALE)
//			)
//		);
//				
////		ADDING ------------------------------------------------
////		Adding an arrayList of elements to the Archive
//		a1.aggiungiElemento(elements);
////		Adding a single elements to the Archive
//		a1.aggiungiElemento(new Libro("3241", "Joke", LocalDate.of(2021, 1, 2), 190, "Rodolfo", "Romantico"));
//		
////		Archive print before
//		System.out.printf("Stato iniziale dell' archivio:%n%n");
//		a1.printArchivio();
//		
////		REMOVE AND RESEARCH BY ------------------------------------------------
//		a1.rimuoviIsbn("5432");
//		System.out.printf("%nStato Attuale dell' archivio:%n%n");
//		a1.printArchivio();
//		
//		a1.ricercaIsbn("1234");
//		a1.ricercaAnno(2022);
//		a1.ricercaAutore("Rodolfo");
//		a1.ricerca(Tipo.TITOLO, "After");
//		
////		SAVE ON DISC ------------------------------------------------
////		Write on disc
////		a1.scriviFile("prova.txt", new Libro("1234", "Libro-1", LocalDate.of(2021, 1, 2), 200, "Cosimo", "Azione"));
//		a1.scriviFile("Archivio.txt", a1);
//		
////		Read from disc
//		System.out.println( "Avvio lettura dal file:" );
//		try {
//			a1.leggiFile("Archivio.txt");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
