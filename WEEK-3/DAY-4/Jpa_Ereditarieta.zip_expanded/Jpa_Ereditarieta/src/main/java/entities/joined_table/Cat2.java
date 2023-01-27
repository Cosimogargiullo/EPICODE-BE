package entities.joined_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Cat2")
@Table(name = "cats_2")
@Getter
@Setter
@NoArgsConstructor
public class Cat2 extends Animal2 {
	
	@Column( name =  "max_jump_height")
	private double maxJumpHeight;
	@Column( name =  "max_speed")
	private double maxSpeed;

	public Cat2(String name, int age, double maxJumpHeight, double maxSpeed) {
		super(name, age);
		this.maxJumpHeight = maxJumpHeight;
		this.maxSpeed = maxSpeed;
	}
	
	
	
	

}
