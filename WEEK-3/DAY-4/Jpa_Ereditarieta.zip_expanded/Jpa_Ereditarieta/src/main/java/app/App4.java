package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.mapped_superclass.Cat4;
import entities.mapped_superclass.Dog4;


public class App4 {
	
	private static final String persistenceUnit = "w3d4";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
    private static final EntityManager em = emf.createEntityManager();
    private static final EntityTransaction t = em.getTransaction();
    
    public static void makeAnimals() {
    	Dog4 d1 = new Dog4("Luca", 34, "chihuahua", 100);
    	Dog4 d2 = new Dog4("Gaetano", 28, "pechinese", 140);
    	Cat4 c1 = new Cat4("Alessia", 20, 2.0, 20.0);
    	Cat4 c2 = new Cat4("Giulia", 30, 4.0, 15.0);
    	
    	t.begin();
    	em.persist(d1);
    	em.persist(d2);
    	em.persist(c1);
    	em.persist(c2);
    	t.commit();

    }
    
    public static void getAnimals() {
    	Dog4 d = em.find(Dog4.class, 1);
    	Cat4 c = em.find(Cat4.class, 1);
    	
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