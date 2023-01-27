package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.joined_table.Cat2;
import entities.joined_table.Dog2;

public class App2 {
	
	private static final String persistenceUnit = "w3d4";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
    private static final EntityManager em = emf.createEntityManager();
    private static final EntityTransaction t = em.getTransaction();
    
    public static void makeAnimals() {
    	Dog2 d1 = new Dog2("Luca", 34, "chihuahua", 100);
    	Dog2 d2 = new Dog2("Gaetano", 28, "pechinese", 140);
    	Cat2 c1 = new Cat2("Alessia", 20, 2.0, 20.0);
    	Cat2 c2 = new Cat2("Giulia", 30, 4.0, 15.0);
    	
    	t.begin();
    	em.persist(d1);
    	em.persist(d2);
    	em.persist(c1);
    	em.persist(c2);
    	t.commit();
    	
    }
    
    public static void getAnimals() {
    	Dog2 d = em.find(Dog2.class, 1);
    	Cat2 c = em.find(Cat2.class, 3);
    	
    	System.out.println(d.getName() + " " + d.getBreed());
    	System.out.println(c.getName() + " " + c.getMaxSpeed());
    }
    
	public static void main(String[] args) {
		//makeAnimals();
		getAnimals();
		em.close();
    	emf.close();
	}

}