package it.epicode.mobilemonitoring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import it.epicode.gestione.dispositivi.exception.GestioneDispositiviException;
import it.epicode.gestione.dispositivi.models.DeviceType;
import it.epicode.mobilemonitoring.repository.DeviceTypeRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeviceTypeService extends GestioneDispositiviService<DeviceType, Long> {

	@Autowired
	private DeviceTypeRepository deviceTypeRepository;

//	OVERRIDE METODI ASTRATTI ---------------------

//	RIDEFINIZIONE DEL METODO ASTRATTO PER DEFINIRE IL REPOSITORY DA UTILIZZARE NEI METODI DELLA SUPERCLASSE ASTRATTA
	@Override
	protected JpaRepository<DeviceType, Long> getRepository() {
		return deviceTypeRepository;
	}

	@Override
	protected void validationInsert(DeviceType obj) throws GestioneDispositiviException {
		typeExist(obj, false);
	}

	@Override
	protected void validationUpdate(DeviceType obj) throws GestioneDispositiviException {
		typeExist(obj, true);
	}

//	VERIFICA ESISTENZA TIPO
	private void typeExist(DeviceType obj, boolean update) throws GestioneDispositiviException {
		Optional<DeviceType> previousElement = deviceTypeRepository.findByName(obj.getName());
		if (previousElement.isPresent()) {
			if (update) {
				if (!previousElement.get().getId().equals(obj.getId())) {
					throw new GestioneDispositiviException("Oggetto con nome: " + obj.getName() + " gia esistente");
				}
			} else {
				throw new GestioneDispositiviException("Oggetto con nome: " + obj.getName() + " gia esistente");
			}
		}
	}

//	GET BY NOME
	public Optional<DeviceType> getByName(String name) {
		Optional<DeviceType> resultOptional = deviceTypeRepository.findByName(name);
		if (resultOptional.isPresent()) {
			log.info("Oggetto con nome {} trovato", name);
		} else {
			log.info("Oggetto con nome {} non trovato", name);
		}
		return resultOptional;
	}

}
