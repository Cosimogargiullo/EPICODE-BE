package it.epicode.be.prenotazioni.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.service.CittaService;

@RestController
public class CittaController {

	@Autowired
	private CittaService cittaService;
	
	@GetMapping("/citta")
	public ResponseEntity<Object> getAll_page(Pageable pageable) {
		Page<Citta> citta = cittaService.findAll(pageable);
		if( citta.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(citta, HttpStatus.OK);
	}
	
	@GetMapping("/byname/{nome}")
	public ResponseEntity<Object> getby(@PathVariable String nome, Pageable pageable) {
		Page<Citta> citta = cittaService.findByNome(nome, pageable);
		if( citta.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(citta, HttpStatus.OK);
	}
	
//	@GetMapping("byname/{nome}")
//	public ResponseEntity<Object> getByName(@PathVariable String nome, Pageable pageable) {
//		Page<Citta> citta = cittaService.findByNome(nome, pageable);
//		if( citta.isEmpty() ) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(citta, HttpStatus.OK);
//	}
	
	@PostMapping("/citta")
	public ResponseEntity<Object> create(@RequestBody Citta c) {
		Citta citta = cittaService.save(c);
		
		return new ResponseEntity<>(citta, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/citta/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		Optional<Citta> cit = cittaService.findById(id);
		ResponseEntity<Object> check = checkExists(cit);
		if( check != null ) return check;
		
		cittaService.delete(cit.get());
		return new ResponseEntity<>(
				String.format("Citta eliminata!"), HttpStatus.OK);
	}
	
	private ResponseEntity<Object> checkExists(Optional<Citta> obj) {
		if( !obj.isPresent() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return null;
	}
	
}
