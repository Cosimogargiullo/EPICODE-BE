package utils;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_1")
public class Person1 {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String surname;

	@Embedded
	private Person1info info;

	public Person1(int id, String name, String surname, Person1info info) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.info = info;
	}

	public Person1() {

	}

}
