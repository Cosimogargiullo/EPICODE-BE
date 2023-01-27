package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import utils.Car;

public class Main {
	
	private static final String persistenceUnit = "lezione";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void insertCar( String plate, String country, String model, int maxSpeed) {
	
		Car c = new Car(plate, country, model, maxSpeed);
		
		t.begin();
		em.persist(c);
		t.commit();
	}

	public static void main(String[] args) {
		
		insertCar("a","it", "model", 200);
		insertCar("b","eng", "model", 100);
		
		
	}

}
