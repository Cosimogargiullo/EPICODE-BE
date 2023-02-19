package it.epicode.be.prenotazioni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.repository.InfoRepository;

@Service
public class PrenotazioniService {
    
	@Autowired
    private InfoRepository prenotazioneRepository;

    public String getRegolePrenotazione(String lingua) throws LinguaNonSupportataException {
        String regolePrenotazione = prenotazioneRepository.getRegolePrenotazione(lingua);
        if (regolePrenotazione == null) {
            throw new LinguaNonSupportataException();
        }
        return regolePrenotazione;
    }
}

