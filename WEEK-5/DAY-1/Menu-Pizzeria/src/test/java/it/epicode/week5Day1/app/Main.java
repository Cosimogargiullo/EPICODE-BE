package it.epicode.week5Day1.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.week5Day1.components.Configuration;
import it.epicode.week5Day1.components.Pizza;
import it.epicode.week5Day1.components.Topping;


public class Main {

	public static void main(String[] args) {
		String divisor = System.lineSeparator();
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class);
		
//		PIZZAS
		System.out.println("PIZZAS");
		System.out.println(divisor);
//		MARGHERITA
		Pizza p1 = (Pizza)ctx.getBean("margherita");
		System.out.println(p1.getProdName() + " " + p1.getIngredienti());

//		HAWAIIAN
		Pizza p2 = (Pizza)ctx.getBean("hawaiian");
		System.out.println(p2.getProdName() + " " + p2.getIngredienti());

//		SALAMI
		Pizza p3 = (Pizza)ctx.getBean("salamiPizza");
		System.out.println(p3.getProdName() + " " + p3.getIngredienti() + " " + p3.getPrezzo());

//		FAMILY
		Pizza p4 = (Pizza)ctx.getBean("salamiPizza");
		p4.getFamilyPizza();
		
		System.out.println(p4.getProdName() + " " + p4.getIngredienti() + " " + p4.getPrezzo());
		System.out.println(divisor);
		
		
		
//		PIZZAS
		System.out.println("Toppings");
		System.out.println(divisor);
//		CHEESE
		Topping t1 = (Topping)ctx.getBean("cheese");
		System.out.println(t1.getProdName() + " " + t1.getCalorie());

		((AnnotationConfigApplicationContext)ctx).close();
	}
	

}
