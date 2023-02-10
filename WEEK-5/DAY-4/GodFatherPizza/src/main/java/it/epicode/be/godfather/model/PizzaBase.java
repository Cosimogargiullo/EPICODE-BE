package it.epicode.be.godfather.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pizze")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
public abstract class PizzaBase implements Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Double price;
	private Double calories;
	
	public PizzaBase(String name, Double price, Double calories) {		
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Double getCalories() {
		return calories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCalories() == null) ? 0 : getCalories().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaBase other = (PizzaBase) obj;
		if (getCalories() == null) {
			if (other.getCalories() != null)
				return false;
		} else if (!getCalories().equals(other.getCalories()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getPrice() == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.getPrice()))
			return false;
		return true;
	}
	
	

}
