package it.epicode.mobilemonitoring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import it.epicode.gestione.dispositivi.exception.GestioneDispositiviException;
import it.epicode.gestione.dispositivi.models.Role;
import it.epicode.mobilemonitoring.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleService extends GestioneDispositiviService<Role, Long> {

	@Autowired
	private RoleRepository roleRepository;

//	OVERRIDE METODI ASTRATTI ---------------------
//	RIDEFINIZIONE DEL METODO ASTRATTO PER DEFINIRE IL REPOSITORY DA UTILIZZARE NEI METODI DELLA SUPERCLASSE ASTRATTA
	@Override
	protected JpaRepository<Role, Long> getRepository() {
		return roleRepository;
	}

//	VALIDAZIONE PER L'INSERIMENTO
	@Override
	protected void validationInsert(Role role) throws GestioneDispositiviException {
		roleExist(role, false);
	}

//	VALIDAZIONE PER L'AGGIORNAMENTO
	@Override
	protected void validationUpdate(Role role) throws GestioneDispositiviException {
		roleExist(role, true);
	}

//	VERIFICA ESISTENZA RUOLO
	private void roleExist(Role role, boolean update) throws GestioneDispositiviException {
		Optional<Role> exist = roleRepository.findByName(role.getName());
		if (exist.isPresent()) {
			if (update) {
				if (!exist.get().getId().equals(role.getId())) {
					throw new GestioneDispositiviException("Ruolo: " + role.getName() + " gia esistente!");
				}
			} else {
				throw new GestioneDispositiviException("Ruolo: " + role.getName() + " gia esistente!");
			}
		}
	}

//	FUNZIONE GET BY NAME
	public Optional<Role> getByImei(String nome) {

		Optional<Role> result = roleRepository.findByName(nome);
		if (result.isPresent()) {
			log.info("Ruolo con nome: {} trovato correttamente!", nome);
		} else {
			log.info("Ruolo con nome: {} non trovato!", nome);
		}
		return result;
	}
	
//	FUNZIONE DELETE BY NAME
	public void deleteByName(String nome) {
		roleRepository.deleteByName(nome);
	}
	
}