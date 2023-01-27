package entities.joined_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Dog2")
@Table(name = "dogs_2")
@Getter
@Setter
@NoArgsConstructor
public class Dog2 extends Animal2 {
	
	private String breed;
	private int price;
	
	public Dog2(String name, int age, String breed, int price) {
		super(name, age);
		this.breed = breed;
		this.price = price;
	}
	
	

}
