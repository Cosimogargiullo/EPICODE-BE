package it.epicode.week5Day1.components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


@org.springframework.context.annotation.Configuration
public class Configuration {
	
//	PIZZAS
	@Bean
	@Scope("prototype")
	public Pizza margherita() {
		return new Pizza("Pizza Margherita", 4.99, 1104);
	}
	@Bean
	@Scope("prototype")
	public Pizza hawaiian() {
		Pizza p = new Pizza("Hawaiian Pizza", 6.49, 1024);
		p.setIngredienti("Ham");
		p.setIngredienti("Pinapple");
		return p;
	}
	@Bean
	@Scope("prototype")
	public Pizza salamiPizza() {
		Pizza p = new Pizza("Salami Pizza", 5.99, 1160);
		p.setIngredienti("Salami");
		return p;
	}
	
//	TOPPINGS
	@Bean
	@Scope("prototype")
	public Topping cheese() {
		return new Topping("Cheese", 0.69, 92);
	}
	@Bean
	@Scope("prototype")
	public Topping ham() {
		return new Topping("Ham", 0.99, 35);
	}
	@Bean
	@Scope("prototype")
	public Topping onion() {
		return new Topping("Onion", 0.69, 22);
	}
	@Bean
	@Scope("prototype")
	public Topping pinapple() {
		return new Topping("Pinapple", 0.79, 24);
	}
	@Bean
	@Scope("prototype")
	public Topping salamiTop() {
		return new Topping("Salami", 0.99, 86);
	}
	
//	DRINKS
	@Bean
	@Scope("prototype")
	public Drink lemonade() {
		return new Drink("Lemonade", 1.29, 128, 0.33);
	}
	@Bean
	@Scope("prototype")
	public Drink water() {
		return new Drink("Water", 1.29, 0, 0.5);
	}
	@Bean
	@Scope("prototype")
	public Drink wine() {
		return new Drink("Wine", 7.79, 607, 0.75, 13);
	}
	
}
