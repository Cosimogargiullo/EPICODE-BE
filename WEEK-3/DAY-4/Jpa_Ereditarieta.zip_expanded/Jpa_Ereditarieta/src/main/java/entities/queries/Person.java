package entities.queries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "getByNameAndAge", query = "SELECT p FROM Person p WHERE p.name = :n AND p.age = :a")
@NamedQuery(name = "getNameByName", query = "SELECT p.name FROM Person p WHERE p.name = :n")
@NamedQuery(name = "getColumnsByName", query = "SELECT p.name, p.age FROM Person p WHERE p.name = :n")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	

}
