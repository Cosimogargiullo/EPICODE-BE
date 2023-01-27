package entities.table_per_class;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "animals_3")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal3 {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	
	public Animal3(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	

}
