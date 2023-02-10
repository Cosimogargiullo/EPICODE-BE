package it.epicode.be.godfather.DAO;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.be.godfather.model.Pizza;
import it.epicode.be.godfather.model.PizzaBase;


@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
//	METHOD -----------------------------------
//	GET ALL
	public List<PizzaBase> getAll() {
		return pizzaRepository.findAll();
	}
	
//	GET BY ID
	public Optional<PizzaBase> getById(int id) {
		return pizzaRepository.findById(id);
	}
	
//	PUT
	public void insert(PizzaBase p) {
		pizzaRepository.save(p);
	}
	
//	UPDATE
	public void update(int id, String fullname) {
		Optional<PizzaBase> pizza = this.getById(id);
		if( pizza.isPresent() ) {
			PizzaBase p = pizza.get();
			p.setName(fullname);
			
			pizzaRepository.save(p);
			System.out.println("Pizza aggiornata correttamente");
		}
		else {
			System.out.println("Nessuna persona trovata con id #" + id);
		}
	}
}
