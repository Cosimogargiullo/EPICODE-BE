package it.epicode.be.week6.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.week6.project.model.Dispositivo;
import it.epicode.be.week6.project.model.Stato;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    List<Dispositivo> findByStato(Stato stato);
}