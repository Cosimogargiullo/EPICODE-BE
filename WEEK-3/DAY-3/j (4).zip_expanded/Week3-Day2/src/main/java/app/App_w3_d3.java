package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.BoxSequence;

public class App_w3_d3 {
	
	private static final String persistenceUnit = "Week3-Day2";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void createBox(int w, int h) {
		BoxSequence box = new BoxSequence();
		box.setWidth(w);
		box.setHeight(h);
		
		t.begin();
		em.persist(box);
		t.commit();
	}
	
	public static void closeEm() {
		em.close();
		emf.close();
	}
	
	// run app
	public static void main(String[] args) {
		createBox(200, 150);

		closeEm();
	}

}
