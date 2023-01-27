package entities.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cats_3")

@Getter
@Setter
@NoArgsConstructor
public class Cat3 extends Animal3 {
	
	@Column( name =  "max_jump_height")
	private double maxJumpHeight;
	@Column( name =  "max_speed")
	private double maxSpeed;

	public Cat3(String name, int age, double maxJumpHeight, double maxSpeed) {
		super(name, age);
		this.maxJumpHeight = maxJumpHeight;
		this.maxSpeed = maxSpeed;
	}
	
	
	
	

}
