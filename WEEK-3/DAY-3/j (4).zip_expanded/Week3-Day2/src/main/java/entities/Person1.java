package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "people_1")
@Getter
@Setter
public class Person1 {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	private String lastname;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
		name = "address_id", referencedColumnName = "id"
	)
	private Address1 address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "person1_project1",
		joinColumns = @JoinColumn( name = "person1_id" ),
		inverseJoinColumns = @JoinColumn( name = "project1_id" )
	)
	Set<Project1> projects = new HashSet<>();
	
	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
	
}
