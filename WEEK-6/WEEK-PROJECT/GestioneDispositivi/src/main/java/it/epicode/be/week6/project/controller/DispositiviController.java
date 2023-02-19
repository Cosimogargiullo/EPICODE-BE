package it.epicode.be.week6.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.week6.project.model.Utente;
import it.epicode.be.week6.project.service.DispositivoService;
import it.epicode.be.week6.project.service.UtenteService;

@RestController
@RequestMapping("/api")
public class DispositiviController {

    private final UtenteService utenteService;
    private final DispositivoService dispositivoService;

    public DispositiviController(UtenteService utenteService, DispositivoService dispositivoService) {
        this.utenteService = utenteService;
        this.dispositivoService = dispositivoService;
    }

    @GetMapping("/utenti")
    public List<Utente> getUtenti() {
        return utenteService.findAll();
    }
    
}

//    @GetMapping("/utenti/{id}")
//    public ResponseEntity<>
