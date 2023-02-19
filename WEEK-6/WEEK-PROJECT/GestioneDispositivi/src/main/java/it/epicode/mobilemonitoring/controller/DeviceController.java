package it.epicode.mobilemonitoring.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.epicode.gestione.dispositivi.exception.GestioneDispositiviException;
import it.epicode.gestione.dispositivi.models.Device;
import it.epicode.mobilemonitoring.service.DeviceService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

//	METODO GET BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Device> obj = deviceService.getById(id);
		if (obj.isPresent()) {
			return new ResponseEntity<>(obj.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity("Device con id: " + id + " non trovato", HttpStatus.NOT_FOUND);
		}
	}

//	METODO GET ALL
	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		List<Device> listDevice = deviceService.findAll();
		if (listDevice.size() > 0) {
			return new ResponseEntity(listDevice, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

//	METODO PER INSERIRE UN OGGETTO
	@PostMapping("/")
	public ResponseEntity<?> insert(@RequestBody Device obj) {
		try {
			obj = deviceService.insert(obj);
			return new ResponseEntity(obj, HttpStatus.CREATED);
		} catch (GestioneDispositiviException e) {
			log.error("Errore nell'inserimento", e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

//	METODO PER AGGIORNARE UN OGGETTO
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody Device obj) {
		try {
			obj = deviceService.update(obj, obj.getId());
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (GestioneDispositiviException e) {
			log.error("Errore nell aggiornamento", e);
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

//	METODO PER ELIMINARE UN OGGETTO
	@DeleteMapping("/")
	public ResponseEntity<?> delete(@RequestBody Device obj) {
		try {
			deviceService.deleteById(obj.getId());
		} catch (EmptyResultDataAccessException e) {
			log.info("Errore nell'eliminazione!");
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

//	ELIMINA PER ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			deviceService.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			log.info("Non e stato trovato nessun device con id: " + id);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
