package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Address;
import entities.Gender;
import entities.Student;

public class App {

	private static final String persistenceUnit = "Week3-Day2";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void insertStudent(String fullname, LocalDate birthdate, Gender gender, int address_id) {
		
		try {
			Student s = new Student();
			s.setFullname(fullname);
			s.setAddress_id(address_id);
			s.setGender(gender);
			s.setBirthdate(birthdate);
			
			t.begin();
			em.persist(s);
			t.commit();
			
			System.out.println("Studente inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dello studente");
		}
		
	}
	
	public static void persist(Object entity) {
		t.begin();
		em.persist(entity);
		t.commit();
	}
	
	public static void insertAddress(String address) {
		
		try {
			Address a = new Address();
			a.setAddress(address);
			persist(a);
			
			System.out.println( "Indirizzo inserito correttamente!" );
		}
		catch(Exception e) {
			System.out.println( "Errore nell'inserimento dell'indirizzo" );
		}
		
	}
	
	public static void getStudentById(int id) {
		Student s = em.find(Student.class, id);
		
		if( s == null ) {
			System.out.println( "Lo studente con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		System.out.println( "Dati studente #" + id );
		System.out.printf(  
			"Nome: %s | Data di nascita: %s | Genere: %s | ID indirizzo: %d%n",
			s.getFullname(), s.getBirthdate().toString(), s.getGender().toString(), s.getAddress_id() 
		);
	}
	
	public static void deleteStudentById(int id) {
		Student s = em.find(Student.class, id);
		
		if( s == null ) {
			System.out.println( "Lo studente con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(s);
		t.commit();
		
		System.out.println( "Lo studente con l'id " + id + " è stato eliminato!" );
	}
	
	public static void updateStudentById(int id, String fullname, LocalDate birthdate, Gender gender) {
		Student s = getStudent(id);
		if( s == null ) return;
		
		try {
			s.setFullname(fullname);
			s.setBirthdate(birthdate);
			s.setGender(gender);
			
			persist(s);
			
			System.out.println("Lo studente con l'id " + id + " è stato aggiornato!");
		}
		catch(Exception e) {
			System.out.println( "Errore nella modifica dello studente!" );
		}
		
	}
	
	public static Student getStudent(int id) {
		Student s = em.find(Student.class, id);
		
		if( s == null ) {
			System.out.println( "Lo studente con l'id " + id + " non è stato trovato!" );
			return null;
		}
		
		return s;
	}
	
	public static void closeEm() {
		em.close();
		emf.close();
	}

	// run app
	public static void main(String[] args) {
		boolean insertStudent = false;
		boolean insertAddress = false;
		boolean deleteStudent = false;
		boolean updateStudent = true;
		
		if( insertStudent )
			insertStudent("Peach Pink", LocalDate.parse("1970-10-01"), Gender.F, 1);
		
		if( insertAddress ) {
			insertAddress("Via Frassineto 10");
		}
		
		if( deleteStudent ) {
			deleteStudentById(3);
		}
		
		if( updateStudent ) {
			updateStudentById(4, "Amanda N", LocalDate.parse("1970-04-01"), Gender.F);
		}
		
		//getStudentById(2);
		
		closeEm();
	}
}
