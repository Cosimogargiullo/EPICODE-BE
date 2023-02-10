package it.epicode.be.godfather.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;

@Entity
public class PizzaMargherita extends PizzaBase {

	public PizzaMargherita() {
		super("Pizza Margherita (tomato, cheese)", 4.99, 1104d);
	}

}
