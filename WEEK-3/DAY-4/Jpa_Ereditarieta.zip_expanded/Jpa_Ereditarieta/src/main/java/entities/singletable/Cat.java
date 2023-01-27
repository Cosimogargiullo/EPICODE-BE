package entities.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Cat")
@Getter
@Setter
@NoArgsConstructor
public class Cat extends Animal {
	
	@Column( name =  "max_jump_height")
	private double maxJumpHeight;
	@Column( name =  "max_speed")
	private double maxSpeed;

	public Cat(String name, int age, double maxJumpHeight, double maxSpeed) {
		super(name, age);
		this.maxJumpHeight = maxJumpHeight;
		this.maxSpeed = maxSpeed;
	}
	
	
	
	

}
