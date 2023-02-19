package it.epicode.gestione.dispositivi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import it.epicode.gestione.dispositivi.exception.GestioneDispositiviException;
import it.epicode.gestione.dispositivi.models.User;
import it.epicode.gestione.dispositivi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService extends GestioneDispositiviService<User, Long> {

//	RIDEFINIZIONE DEL METODO ASTRATTO PER DEFINIRE IL REPOSITORY DA UTILIZZARE NEI METODI DELLA SUPERCLASSE ASTRATTA
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	OVERRIDE METODI ASTRATTI ---------------------
	@Override
	protected JpaRepository<User, Long> getRepository() {
		return userRepository;
	}
	
//	VALIDAZIONE PER L'INSERIMENTO
	@Override
	protected void validationInsert(User obj) throws GestioneDispositiviException {
		userExist(obj, false);
	}

//	VALIDAZIONE PER L'AGGIORNAMENTO
	@Override
	protected void validationUpdate(User obj) throws GestioneDispositiviException {
		userExist(obj, true);
	}

	@Override
	protected void beforeSave(User user) {
		if (!user.getPassword().isEmpty()) {
			String encoded = passwordEncoder.encode(user.getPassword());
			user.setPassword(encoded);
		}
	}
	
//	VERIFICA ESISTENZA UTENTE
	private void userExist(User user, boolean update) throws GestioneDispositiviException {

		Optional<User> exist = userRepository.findByUsername(user.getUsername());
		if (exist.isPresent()) {
			if (update) {
				if (!exist.get().getId().equals(user.getId())) {
					throw new GestioneDispositiviException(
							"Utente con username: " + user.getUsername() + " esiste gia.");
				}
			} else {
				throw new GestioneDispositiviException("User con username: " + user.getUsername() + " esiste gia");
			}
		}
	}

//	FUNZIONE GET BY USERNAME
	public Optional<User> getByUsername(String name, boolean ignoreCase) {
		Optional<User> result = userRepository.findByUsername(name);
		if (result.isPresent()) {
			log.info("User con username: {} trovato correttamente", name);
		} else {
			log.info("User con username: {} non trovato!", name);

		}
		return result;
	}
}
