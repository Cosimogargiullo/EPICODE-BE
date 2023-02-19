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
import it.epicode.gestione.dispositivi.models.DeviceType;
import it.epicode.gestione.dispositivi.service.DeviceTypeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/devicetype")
public class DeviceTypeController {

	@Autowired
	private DeviceTypeService deviceTypeService;

//	METODO GET ALL
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SYSADMIN') or hasRole('DEVELOPER')")
	public ResponseEntity<?> findAll() {
		List<DeviceType> listDeviceType = deviceTypeService.findAll();
		if (listDeviceType.size() > 0) {
			return new ResponseEntity(listDeviceType, HttpStatus.OK);
		} else {
			return new ResponseEntity("Lista vuota!", HttpStatus.NOT_FOUND);
		}
	}

//	METODO GET BY ID
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SYSADMIN') or hasRole('DEVELOPER')")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<DeviceType> obj = deviceTypeService.getById(id);
		if (obj.isPresent()) {
			return new ResponseEntity<>(obj.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity("Device con id: " + id + " non trovato!", HttpStatus.NOT_FOUND);
		}
	}

//	METODO PER INSERIRE UN OGGETTO
	@PostMapping("/")
	@PreAuthorize("hasRole('SYSADMIN')")
	public ResponseEntity<?> insert(@RequestBody DeviceType objectToInsert) {
		try {
			objectToInsert = deviceTypeService.insert(objectToInsert);
			return new ResponseEntity(objectToInsert, HttpStatus.CREATED);
		} catch (GestioneDispositiviException e) {
			log.error("Errore inserimento", e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

//	METODO PER AGGIORNARE UN OGGETTO
	@PutMapping("/")
	@PreAuthorize("hasRole('SYSADMIN')")
	public ResponseEntity<?> update(@RequestBody DeviceType objectToUpdate) {
		try {
			objectToUpdate = deviceTypeService.update(objectToUpdate, objectToUpdate.getId());
			return new ResponseEntity<>(objectToUpdate, HttpStatus.OK);
		} catch (GestioneDispositiviException e) {
			log.error("Errore inserimento", e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

//	METODO PER ELIMINARE UN OGGETTO
	@DeleteMapping("/")
	@PreAuthorize("hasRole('SYSADMIN')")
	public ResponseEntity<?> delete(@RequestBody DeviceType objectToDelete) {
		try {
			deviceTypeService.deleteById(objectToDelete.getId());
		} catch (EmptyResultDataAccessException e) {
			log.info("Errore nell'eliminazione!");
		}
		return new ResponseEntity(HttpStatus.OK);
	}

//	ELIMINA PER ID
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('SYSADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			deviceTypeService.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			log.info("Nessun device trovato con id: " + id);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

}
