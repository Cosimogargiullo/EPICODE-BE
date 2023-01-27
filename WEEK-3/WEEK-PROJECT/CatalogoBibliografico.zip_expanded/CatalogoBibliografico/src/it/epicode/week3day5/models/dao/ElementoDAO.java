package it.epicode.week3day5.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.epicode.week3day5.models.Elemento;
import it.epicode.week3day5.models.JpaUtil;
import it.epicode.week3day5.models.Prestito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementoDAO {
	public static String divisor = "-------------------------------------------";
	private static final Logger logger = LoggerFactory.getLogger(ElementoDAO.class);
	
//	Method SALVA
	public static void saveElement(Object e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(e);

			transaction.commit();

			System.out.println(divisor);
			System.out.println("Il seguente Oggetto e salvato con successo (" + e.toString() + ")");
			System.out.println(divisor);

		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error salvataggio elemento");
			throw ex;

		} finally {
			em.close();
		}
	}

//	Method DELETE BY ISBN
	public static void deleteByISBN(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("getByISBN");
			query.setParameter("isbn", isbn);
			Elemento e = (Elemento) query.getSingleResult();

			em.remove(e);
			transaction.commit();
			System.out.println(divisor);
			System.out.println("Elemento cod_isbn: " + e.getCodIsbn() + " eliminato con successo");
			System.out.println(divisor);

		} catch (Exception ex) {
			logger.error("Error eliminazione elemento per ISBN");
			em.getTransaction().rollback();
			throw ex;

		} finally {
			em.close();
		}
	}

//	Method GET BY ISBN
	public static void getByISBN(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("getByISBN");
			query.setParameter("isbn", isbn);
			Elemento e = (Elemento) query.getSingleResult();

			transaction.commit();
			System.out.println(divisor);
			System.out.println("L'Elemento con codice ISBN: " + isbn + " e il seguente: " + e.toString());
			System.out.println(divisor);

		} catch (Exception ex) {
			logger.error("Error elemento con ISBN: " + isbn + "  non trovato");
			em.getTransaction().rollback();
			throw ex;

		} finally {
			em.close();
		}

	}

//	Method GET BY YEAR
	public static void getByAnno(int anno) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("getByAnno");
			query.setParameter("anno", anno);
			List<Elemento> e = query.getResultList();

			transaction.commit();
			System.out.println(divisor);
			System.out.println("La ricerca per anno: " + anno + " ha prodotto i seguenti risultat: ");
			e.forEach(el -> System.out.println(el.toString()));
			System.out.println(divisor);

		} catch (Exception ex) {
			logger.error("Error elementi per anno: " + anno + " non trovato");
			em.getTransaction().rollback();
			throw ex;

		} finally {
			em.close();
		}
	}

//	Method GET BY AUTHOR
	public static void getByAutore(String autore) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("getByAutore");
			query.setParameter("autore", autore);
			List<Elemento> e = query.getResultList();

			transaction.commit();
			System.out.println(divisor);
			System.out.println("La ricerca per autore: " + autore + " ha prodotto i seguenti risultati: ");
			e.forEach(el -> System.out.println(el.toString()));
			System.out.println(divisor);

		} catch (Exception ex) {
			logger.error("Error elementi per autore: " + autore + " non trovato");
			em.getTransaction().rollback();
			throw ex;

		} finally {
			em.close();
		}

	}

//	Method GET BY TITOLO
	public static void getByTitolo(String titolo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("getByTitolo");
			query.setParameter("titolo", "%" + titolo + "%");
			List<Elemento> e = query.getResultList();

			transaction.commit();
			System.out.println(divisor);
			System.out.println("La ricerca per titolo: " + titolo + " ha prodotto i seguenti risultati: ");
			e.forEach(el -> System.out.println(el.toString()));
			System.out.println(divisor);

		} catch (Exception ex) {
			logger.error("Error elementi per titolo: " + titolo + " non trovato");
			em.getTransaction().rollback();
			throw ex;

		} finally {
			em.close();
		}

	}

//	Method GET ELEMENTI IN PRESTITO PER NUMERO TESSERA
	public static void getElementiPrestati(int tessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("getElementiPrestati");
			query.setParameter("tessera", tessera);
			List<Prestito> e = query.getResultList();

			transaction.commit();
			System.out.println(divisor);
			System.out.println("Elementi attualmente in prestito dalla tessera: " + tessera
					+ " ha prodotto i seguenti risultati: ");
			e.forEach(el -> System.out.println(el.getElementoPrestato().toString()));
			System.out.println(divisor);

		} catch (Exception ex) {
			logger.error("Error elementi per titolo: " + tessera + " non trovato");
			em.getTransaction().rollback();
			throw ex;

		} finally {
			em.close();
		}

	}

//	Method GET PRESTITI SCADUTI NON RESTITUITI
	public static void getPrestitiScaduti() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Query query = em.createNamedQuery("getPrestitiScaduti");
			List<Prestito> e = query.getResultList();

			transaction.commit();
			System.out.println(divisor);
			System.out.println("I prestiti scaduti non ancora restituiti sono: ");
			e.forEach(el -> System.out.println(el.toString()));
			System.out.println(divisor);

		} catch (Exception ex) {
			logger.error("Errore");
			em.getTransaction().rollback();
			throw ex;

		} finally {
			em.close();
		}

	}

}
