package it.epicode.be.week6.project.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.be.week6.project.model.Utente;
import it.epicode.be.week6.project.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
    UtenteRepository urepository;

    public List<Utente> findAll() {
        return urepository.findAll();
    }

    public Optional<Utente> findById(Long id) {
        return urepository.findById(id);
    }

    public Optional<Utente> findByUsername(String username) {
        return urepository.findByUsername(username);
    }

    public Utente save(Utente utente) {
        return urepository.save(utente);
    }

    public void deleteById(Long id) {
        urepository.deleteById(id);
    }
}

