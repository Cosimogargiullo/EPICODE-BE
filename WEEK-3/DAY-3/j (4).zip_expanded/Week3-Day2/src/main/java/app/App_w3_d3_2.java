package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Address1;
import entities.Person1;

public class App_w3_d3_2 {
	
	private static final String persistenceUnit = "Week3-Day2";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void insertAddress(String road, String city) {
		Address1 a = new Address1();
		a.setRoad(road);
		a.setCity(city);
		
		t.begin();
		em.persist(a);
		t.commit();
	}
	
	public static void insertPerson(String fn, String ln, int address_id) {
		Address1 a = em.find(Address1.class, address_id);
		if( a == null ) return;
		
		Person1 p = new Person1();
		p.setFirstname(fn);
		p.setLastname(ln);
		p.setAddress(a);
		
		t.begin();
		em.persist(p);
		t.commit();
	}
	
	public static void personInfo(int id) {
		Person1 p = em.find(Person1.class, id);
		if( p == null ) {
			System.out.println( "La persona non esiste!" );
			return;
		}
		
		System.out.println( "Person info:" );
		System.out.println( p );
		System.out.println( "Indirizzo: " + p.getAddress().getRoad() + " " + p.getAddress().getCity() );
	}
	
	public static void addressInfo(int id) {
		Address1 a = em.find(Address1.class, id);
		if( a == null ) return;
		
		System.out.println( "Address info:" );
		System.out.println( a.getRoad() + " " + a.getCity() );
		System.out.println( "Persone che abitano qui:" );
		for(Person1 p : a.getPeople()) {
			System.out.println( p );
		}
	}
	
	// run app
	public static void main(String[] args) {
		
		boolean addAddress = false;
		boolean addPerson = false;
		boolean showPersonInfo = true;
		
		if( addAddress ) {
			insertAddress("Via Ciao 10", "Milano");
		}
		
		if( addPerson ) {
			insertPerson("Luigi", "Verdi", 1);
		}
		
		if( showPersonInfo ) {
			personInfo(2);
			System.out.println();
			addressInfo(1);
		}

	}

}
