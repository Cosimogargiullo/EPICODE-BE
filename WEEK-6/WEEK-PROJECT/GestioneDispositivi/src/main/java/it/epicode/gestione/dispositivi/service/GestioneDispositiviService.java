package it.epicode.gestione.dispositivi.service;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import it.epicode.gestione.dispositivi.exception.GestioneDispositiviException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
//UTILIZZO DEI GENERICS PER RENDERE MODULARE IL SERVICE
public abstract class GestioneDispositiviService<T,ID> {

//	METODI ASTRATTI
//	GET REPOSITORY CON GENERICS PER POTER CREARE METODI GENERICI UTILIZZABILI DA PIU CLASSI
	protected abstract JpaRepository<T, ID> getRepository();
	
//	VALIDAZIONE PER L'INSERIMENTO
	protected abstract void validationInsert(T objectToInsert) throws GestioneDispositiviException;
	
//	VALIDAZIONE PER L'AGGIORNAMENTO
	protected abstract void validationUpdate(T objectToUpdate) throws GestioneDispositiviException;
	
//	POST 
	public T insert(T obj) throws GestioneDispositiviException {
		validationInsert(obj);
		beforeSave(obj);
		T result = getRepository().save(obj);
		log.info("Oggetto: {} inserito correttamente", result);
		return result;
	}
	
//	GET BY ID
	public Optional<T> getById(ID id) {
		Optional<T> result = getRepository().findById(id);
		if (result.isPresent()) {
			log.info("Oggetto con id: {} trovato correttamente!", id);
		} else {
			log.info("Oggetto con id: {} non trovato!", id);
		}
		return result;
	}

	public List<T> findAll() {
		log.info("Finding all objects");

		List<T> findAll = getRepository().findAll();
		
		log.info("Found {} objects", findAll.size());

		return findAll;
	}
	
//	UPDATE
	public T update(T obj, ID id) throws GestioneDispositiviException {
		validationUpdate(obj);
		Optional<T> repoObj = getRepository().findById(id);
		if (repoObj.isPresent()) {
			T savedObject = repoObj.get();
			beforeSave(savedObject);
			savedObject = getRepository().save(savedObject);
			log.info("Oggetto con id: {} aggiornato correttamente! == {}", id, savedObject);
			return savedObject;
		} else {
			throw new GestioneDispositiviException("Elemento con id: " + id + "non presente");
		}
	}

//	FUNZIONE D'APPOGGIO PER EFFETTUARE LE MODIFICHE DI UN OGGETTO NELLA FUNZI
	protected void beforeSave(T savedObject) {
	}
	
//	ELIMINA PER ID
	public void deleteById(ID id) {
		getRepository().deleteById(id);
	}
}
