package entities.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Dog")
@Getter
@Setter
@NoArgsConstructor
public class Dog extends Animal {
	
	private String breed;
	private int price;
	
	public Dog(String name, int age, String breed, int price) {
		super(name, age);
		this.breed = breed;
		this.price = price;
	}
	
	

}
