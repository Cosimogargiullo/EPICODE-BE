package it.epicode.gestione.dispositivi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.epicode.gestione.dispositivi.exception.GestioneDispositiviException;
import it.epicode.gestione.dispositivi.models.Role;
import it.epicode.gestione.dispositivi.service.RoleService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/ruoli")
public class RoleController {

	@Autowired
	private RoleService service;

//	METODO GET BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Role> obj = service.getById(id);
		if (obj.isPresent()) {
			return new ResponseEntity<>(obj.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity("Ruolo con id: " + id + " non trovato!", HttpStatus.NOT_FOUND);
		}
	}

//	METODO GET ALL
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> findAll() {
		List<Role> listRole = service.findAll();
		if (listRole.size() > 0) {
			return new ResponseEntity(listRole, HttpStatus.OK);
		} else {
			return new ResponseEntity("Lista vuota!", HttpStatus.NOT_FOUND);
		}
	}
	
//	METODO PER INSERIRE UN OGGETTO
	@PostMapping("/")
	public ResponseEntity<?> insert(@RequestBody Role obj) {
		try {
			obj = service.insert(obj);
			return new ResponseEntity(obj, HttpStatus.CREATED);

		} catch (GestioneDispositiviException e) {
			log.error("Errore nell'inserimento", e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

//	METODO PER AGGIORNARE UN OGGETTO
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody Role obj) {
		try {
			obj = service.update(obj, obj.getId());
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (GestioneDispositiviException e) {
			log.error("Errore nell'aggiornamento", e);
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

//	METODO PER ELIMINARE UN OGGETTO
	@DeleteMapping("/")
	public ResponseEntity<?> delete(@RequestBody Role obj) {
		try {
			service.deleteById(obj.getId());
			return new ResponseEntity<>(obj, HttpStatus.GONE);

		} catch (EmptyResultDataAccessException e) {
			log.info("Ruolo non esistente!");
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

//	METODO ELIMINA PER ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.GONE);
		} catch (EmptyResultDataAccessException e) {
			log.info("Ruolo con id " + id + " non esistente!");
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
