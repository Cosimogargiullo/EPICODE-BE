package entities.table_per_class;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dogs_3")
@Getter
@Setter
@NoArgsConstructor
public class Dog3 extends Animal3 {
	
	private String breed;
	private int price;
	
	public Dog3(String name, int age, String breed, int price) {
		super(name, age);
		this.breed = breed;
		this.price = price;
	}
	
	

}
