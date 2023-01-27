package entities.mapped_superclass;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dogs_4")
@Getter
@Setter
@NoArgsConstructor
public class Dog4 extends Animal4 {
	
	private String breed;
	private int price;
	
	public Dog4(String name, int age, String breed, int price) {
		super(name, age);
		this.breed = breed;
		this.price = price;
	}
	
	

}
