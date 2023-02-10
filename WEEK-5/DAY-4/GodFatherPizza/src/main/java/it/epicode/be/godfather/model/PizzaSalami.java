package it.epicode.be.godfather.model;

import javax.persistence.Entity;

@Entity
public class PizzaSalami extends PizzaBase {

	public PizzaSalami() {
		super("Pizza Salami (tomato, cheese, salami)", 5.99, 1160d);
	}

}
