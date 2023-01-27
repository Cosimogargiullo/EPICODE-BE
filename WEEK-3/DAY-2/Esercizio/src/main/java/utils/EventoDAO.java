package utils;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EventoDAO {

	private static final String persistenceUnit = "gestione_eventi";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void inserisciEvento(String titolo, LocalDate data, String descrizione, TipoEvento tipo,
			int numero_massimo_partecipanti) {

		try {
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setData_evento(data);
			e.setDescrizione(descrizione);
			e.setTipo_evento(tipo);
			e.setNumero_massimo_partecipanti(numero_massimo_partecipanti);
			t.begin();
			em.persist(e);
			t.commit();
			System.out.println("Evento inserito correttamente!");
		} catch (Exception e) {
			System.out.println("Errore nell'inserimento dell'evento");
		}

	}
	
	public static void getEventoById(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		System.out.println( "Dati evento #" + id );
		System.out.printf(  
			"Titolo: %s | Data Evento: %s | Descrizione: %s | Tipo: %s | Numero massimo parctecipanti: %d%n",
			e.getTitolo(), e.getData_evento().toString(), e.getDescrizione(), e.getTipo_evento().toString(), e.getNumero_massimo_partecipanti());
	}
	
	public static void deleteEvento(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		
		System.out.println( "L'evento con l'id " + id + " è stato eliminato!" );
	}
	
	public static void refreshEvento(int id, String titolo, LocalDate data, String descrizione, TipoEvento tipo,
			int numero_massimo_partecipanti) {
		Evento e = em.find(Evento.class, id);
		if( e == null ) return;
		
		try {
			e.setTitolo(titolo);
			e.setData_evento(data);
			e.setDescrizione(descrizione);
			e.setTipo_evento(tipo);
			e.setNumero_massimo_partecipanti(numero_massimo_partecipanti);
			persist(e);
			
			System.out.println("L'evento con l'id " + id + " è stato aggiornato!");
		}
		catch(Exception ex) {
			System.out.println( "Errore nella modifica dell'evento!" );
		}
		
	}
	
	public static void persist(Object entity) {
		t.begin();
		em.persist(entity);
		t.commit();
	}
	
	public static void closeEm() {
		em.close();
		emf.close();
	}
	
}
