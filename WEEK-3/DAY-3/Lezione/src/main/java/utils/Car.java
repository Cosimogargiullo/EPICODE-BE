package utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cars_2")
@IdClass(CarPk.class)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	@Id
	private String plate;
	@Id
	private String country;
	private String model;
	@Column(name = "max_speed")
	private int maxSpeed;

	public Car() {
	};

//	Constructor --------------------------------------
	public Car(String plate, String country, String model, int maxSpeed) {
		super();
		this.plate = plate;
		this.country = country;
		this.model = model;
		this.maxSpeed = maxSpeed;
	}

//	Getters - Setters --------------------------------------
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
