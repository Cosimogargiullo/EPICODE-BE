package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import utils.Person1;
import utils.Person1info;

public class Main2 {

	private static final String persistenceUnit = "lezione";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void insertPerson(String fn, String sn, double h, double w, int age,  String cf) {

		Person1info p1 = new Person1info(h, w, age, cf);
		Person1 p = new Person1(1, fn, sn, p1);
		

		t.begin();
		em.persist(p);
		t.commit();
	}

	public static void main(String[] args) {

		insertPerson("cosimo", "gargiullo", 1, 2, 3, "cf");
	}

}
