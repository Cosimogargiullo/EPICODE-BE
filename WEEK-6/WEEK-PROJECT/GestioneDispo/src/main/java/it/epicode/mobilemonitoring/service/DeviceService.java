package it.epicode.mobilemonitoring.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import it.epicode.gestione.dispositivi.exception.GestioneDispositiviException;
import it.epicode.gestione.dispositivi.models.Device;
import it.epicode.mobilemonitoring.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeviceService extends GestioneDispositiviService<Device, Long> {

	@Autowired
	private DeviceRepository deviceRepository;
	
//	OVERRIDE METODI ASTRATTI ---------------------
	
//	RIDEFINIZIONE DEL METODO ASTRATTO PER DEFINIRE IL REPOSITORY DA UTILIZZARE NEI METODI DELLA SUPERCLASSE ASTRATTA
	@Override
	protected JpaRepository<Device, Long> getRepository() {
		return deviceRepository;
	}
	
//	VALIDAZIONE PER L'INSERIMENTO
	@Override
	protected void validationInsert(Device device) throws GestioneDispositiviException {
		imeiExist(device, false);
	}

//	VALIDAZIONE PER L'AGGIORNAMENTO
	@Override
	protected void validationUpdate(Device device) throws GestioneDispositiviException {
		imeiExist(device, true);
	}

//	MODIFICHE DA EFFETTUARE SULL OGGETTO PRIMA DI AGGIORNARLO
	@Override
	protected void beforeSave(Device device) {
		device.setStatusChangeDate(new Date());
	}

//	VERIFICA ESISTENZA DEVICE, BOOLEANO PER DETERMINARE LA FONTE  DELL'INVOCAZIONE, SE TRUE SVOLGE VERIFICA PER L'UPDATE
	private void imeiExist(Device device, boolean update) throws GestioneDispositiviException {

		Optional<Device> exist = deviceRepository.findByImei(device.getImei());
		if (exist.isPresent()) {
			if (update) {
				if (!exist.get().getId().equals(device.getId())) {
					throw new GestioneDispositiviException("Device con IMEI: " + device.getImei() + " esiste gia.");
				}
			} else {
				throw new GestioneDispositiviException("Device con IMEI: " + device.getImei() + " esiste gia");
			}
		}
	}

//	FUNZIONE GET BY IMEI
	public Optional<Device> getByImei(String imei) {

		Optional<Device> result = deviceRepository.findByImei(imei);
		if (result.isPresent()) {
			log.info("Oggetto con IMEI: {} trovato correttamente!", imei);
		} else {
			log.info("Oggetto con IMEI: {} non trovato!", imei);
		}
		return result;
	}

//	FUNZIONE DELETE BY IMEI
	public void deleteByImei(String imei) {
		deviceRepository.deleteByImei(imei);
	}

//	FUNZIONE GET BY TIPO
	public List<Device> getByDeviceTypeName(String tipo) {
		return deviceRepository.findByDeviceTypeName(tipo);
	}

//	FUNZIONE GET BY TIPO CON PAGINAZIONE
	public Page<Device> getByDeviceTypeName(String tipo, Pageable pageable) {
		return deviceRepository.findByDeviceTypeName(tipo, pageable);
	}
}
