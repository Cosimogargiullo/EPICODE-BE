package it.epicode.be.godfather;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import it.epicode.be.godfather.DAO.PizzaService;
import it.epicode.be.godfather.config.MenuConfig;
import it.epicode.be.godfather.model.PizzaBase;
import it.epicode.be.godfather.model.PizzaHawaiian;
import it.epicode.be.godfather.model.PizzaMargherita;
import it.epicode.be.godfather.model.PizzaSalami;

@Component
public class PersistenceRunner implements CommandLineRunner {

	@Autowired
	PizzaService ps;
	
//	ApplicationContext ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
	
	
	@Override
	public void run(String... args) throws Exception {
			insertPizza();
			getPizzaById(1);
			updatePizzaById(1,"Pizza Modisicata");
	}
	
	public void insertPizza() {
		PizzaBase p = new PizzaHawaiian();
		ps.insert(p);
	}
	
	public void getPizzaById(int id) {
		Optional<PizzaBase> pizza = ps.getById(id);
		if( pizza.isPresent() ) {
			PizzaBase p = pizza.get();
			System.out.println("Info pizza con id #" + id + ":");
			System.out.println( p );
		}
		else {
			System.out.println("Pizza non trovata con id #" + id);
		}
	}
	
	public void updatePizzaById(int id, String fullname) {
		ps.update(id, fullname);
	}
	
	

}
