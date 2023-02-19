package it.epicode.be.prenotazioni.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import it.epicode.be.prenotazioni.model.Citta;

public interface CittaRepository extends JpaRepository<Citta, Long> {
	
	public Page<Citta> findByNome(@Param("nome")String nome, Pageable pageable);
	public Optional<Citta> findById(@Param("id")Long id);
}
