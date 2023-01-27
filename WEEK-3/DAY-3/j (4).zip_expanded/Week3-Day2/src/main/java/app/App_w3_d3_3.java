package app;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Person1;
import entities.Project1;

public class App_w3_d3_3 {
	
	private static final String persistenceUnit = "Week3-Day2";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void populateDB() {
		t.begin();
		
		Project1 p1 = new Project1();
		p1.setName("red project");
		p1.setDescription("this is a red project");
		
		Project1 p2 = new Project1();
		p2.setName("green project");
		p2.setDescription("this is a green project");
		
		Project1 p3 = new Project1();
		p3.setName("blue project");
		p3.setDescription("this is a blue project");
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		Person1 person1 = em.find(Person1.class, 1);
		Person1 person2 = em.find(Person1.class, 2);
		
		person1.setProjects( new HashSet<>() {{
			add(p1);
			add(p2);
		}} );
		
		person2.setProjects( new HashSet<>() {{
			add(p1);
			add(p3);
		}} );
		
		em.persist(person1);
		em.persist(person2);
		t.commit();
	}
	
	public static void getPersonInfo(int id) {
		Person1 p = em.find(Person1.class, id);
		System.out.println( "Info Person: " + p );
		System.out.println( "Progetti:" );
		for( Project1 project : p.getProjects() ) {
			System.out.println( project );
		}
	}
	
	// run app
	public static void main(String[] args) {
		
		boolean populateDB = false;
		if( populateDB )
			populateDB();
		
		getPersonInfo(2);
		
		

	}

}
