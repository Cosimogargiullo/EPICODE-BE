package it.epicode.be.prenotazioni.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class InfoRepository {

    @Value("${gestioneprenotazioni.istruzioniItaliano}")
    private String regolePrenotazioneItaliano;

    @Value("${gestioneprenotazioni.istruzioniInglese}")
    private String regolePrenotazioneInglese;

    public String getRegolePrenotazione(String lingua) {
        switch (lingua.toLowerCase()) {
            case "italiano":
                return regolePrenotazioneItaliano;
            case "inglese":
                return regolePrenotazioneInglese;
            default:
                return null;
        }
    }
}

