package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.singletable.Cat;
import entities.singletable.Dog;

public class App1 {
	
	private static final String persistenceUnit = "w3d4";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
    private static final EntityManager em = emf.createEntityManager();
    private static final EntityTransaction t = em.getTransaction();
    
    public static void makeAnimals() {
    	Dog d1 = new Dog("Luca", 34, "chihuahua", 100);
    	Dog d2 = new Dog("Gaetano", 28, "pechinese", 140);
    	Cat c1 = new Cat("Alessia", 20, 2.0, 20.0);
    	Cat c2 = new Cat("Giulia", 30, 4.0, 15.0);
    	
    	t.begin();
    	em.persist(d1);
    	em.persist(d2);
    	em.persist(c1);
    	em.persist(c2);
    	t.commit();
    	em.close();
    	emf.close();
    }
    
	public static void main(String[] args) {
		makeAnimals();
	}

}