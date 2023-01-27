package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import entities.queries.Address;
import entities.queries.Person;


public class App5 {
	
	private static final String persistenceUnit = "w3d4";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
    private static final EntityManager em = emf.createEntityManager();
    private static final EntityTransaction t = em.getTransaction();
    
    public static void makePeople() {
    	Person p1 = new Person("Luca", 34);
    	Person p2 = new Person("Gaetano", 28);
    	Person p3 = new Person("Alessia", 20);
    	Person p4 = new Person("Giulia", 30);
    	
    	t.begin();
    	em.persist(p1);
    	em.persist(p2);
    	em.persist(p3);
    	em.persist(p4);
    	t.commit();

    }
    
    public static void makeAddress() {
    	Address a = new Address();
    	a.setRoad("Via Ciao 10");
    	
    	t.begin();
    	em.persist(a);
    	t.commit();

    }
    
    public static void getPeopleByName(String name) {
    	
    	Query q = em.createQuery("SELECT p FROM Person p WHERE name = :n");
    	q.setParameter("n", name);
    	
    	List<Person> res = q.getResultList();
    	
    	for(Person p:res) {
    		System.out.println(p);
    	}
    	
    }
    
    public static void getPeopleByNameAndAge(String name, int age) {
    	
    	Query q = em.createNamedQuery("getByNameAndAge");
    	q.setParameter("n", name);
    	q.setParameter("a", age);
    	
    	List<Person> res = q.getResultList();
    	
    	for(Person p:res) {
    		System.out.println(p);
    	}
    	
    }
    
    public static void getPeopleNameByName(String name) {
    	
    	Query q = em.createNamedQuery("getNameByName");
    	q.setParameter("n", name);
    	
    	List<String> res = q.getResultList();
    	
    	for(String n:res) {
    		System.out.println(n);
    	}
    	
    }
    
    public static void getColumnsByName(String name) {
    	
    	Query q = em.createNamedQuery("getColumnsByName");
    	q.setParameter("n", name);
    	
    	List<Object[]> res = q.getResultList();
    	
    	for(Object[] obj:res) {
    		System.out.println(obj[0] + " " + obj[1]);
    	}
    	
    }
    
    public static void updateById(int id, String name) {
    	t.begin();
    	
    	Query q = em.createQuery("UPDATE Person p SET name = :n WHERE id = :id");
    	q.setParameter("n", name);
    	q.setParameter("id", id);
    	
    	int rowAffected = q.executeUpdate();
    	System.out.println("hai modificato " + rowAffected + " righe");
    	
    	t.commit();
    }
    
    public static void select(String name) {
    	// "SELECT p FROM Person p WHERE name = :n"
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<Person> qu = cb.createQuery(Person.class);
    	Root<Person> f = qu.from(Person.class);
    	ParameterExpression<String> pe = cb.parameter(String.class);
    	
    	qu.select(f).where(
    		cb.equal(f.get("name"), pe)
    	);
    	
    	TypedQuery<Person> q = em.createQuery(qu);
    	q.setParameter(pe, name);
    	
    	List<Person> res = q.getResultList();
    	
    	for(Person p:res) {
    		System.out.println(p);
    	}
    }
    
    public static void getPersonByAddress(String road) {
    	
    	Query q = em.createQuery("SELECT p FROM Person p WHERE p.address.road = :n");
    	q.setParameter("n", road);
    	
    	List<Person> res = q.getResultList();
    	
    	for(Person p:res) {
    		System.out.println(p.getName());
    	}
    	
    }
    
	public static void main(String[] args) {
		//makePeople();
		//getPeopleByName("Luca");
		//getPeopleByNameAndAge("Alessia", 20);
		//getPeopleNameByName("Giulia");
		//getColumnsByName("Gaetano");
		//updateById(1, "khamzat");
		//select("Alessia");
		//makeAddress();
		getPersonByAddress("Via Ciao 10");
		em.close();
    	emf.close();
	}

}