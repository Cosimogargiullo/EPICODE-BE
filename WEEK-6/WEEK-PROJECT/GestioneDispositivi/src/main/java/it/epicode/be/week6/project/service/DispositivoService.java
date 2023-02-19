package it.epicode.be.week6.project.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.be.week6.project.model.Dispositivo;
import it.epicode.be.week6.project.model.Stato;
import it.epicode.be.week6.project.repository.DispositivoRepository;

@Service
public class DispositivoService {

	@Autowired
    DispositivoRepository drepository;

    public DispositivoService(DispositivoRepository repository) {
        this.drepository = repository;
    }

    public List<Dispositivo> findAll() {
        return drepository.findAll();
    }

    public Optional<Dispositivo> findById(Long id) {
        return drepository.findById(id);
    }

    public List<Dispositivo> findByStato(Stato stato) {
        return drepository.findByStato(stato);
    }

    public Dispositivo save(Dispositivo dispositivo) {
        return drepository.save(dispositivo);
    }

    public void deleteById(Long id) {
        drepository.deleteById(id);
    }
}
