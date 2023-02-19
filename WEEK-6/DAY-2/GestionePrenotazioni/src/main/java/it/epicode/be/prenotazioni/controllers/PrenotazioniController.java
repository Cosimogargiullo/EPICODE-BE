package it.epicode.be.prenotazioni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.epicode.be.prenotazioni.services.LinguaNonSupportataException;
import it.epicode.be.prenotazioni.services.PrenotazioniService;

@RestController
public class PrenotazioniController {

    @Autowired
    private PrenotazioniService prenotazioneService;

    @GetMapping("/regolePrenotazione")
    public ResponseEntity<String> getRegolePrenotazione(@RequestParam String lingua) {
        try {
            String regolePrenotazione = prenotazioneService.getRegolePrenotazione(lingua);
            return ResponseEntity.ok(regolePrenotazione);
        } catch (LinguaNonSupportataException e) {
            return ResponseEntity.badRequest().body("Lingua non supportata");
        }
    }
}

