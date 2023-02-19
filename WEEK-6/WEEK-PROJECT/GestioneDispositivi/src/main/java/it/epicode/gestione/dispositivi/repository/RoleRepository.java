package it.epicode.gestione.dispositivi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.gestione.dispositivi.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public Optional<Role> findByName(String name);
	
	public void deleteByName(String nome);
}
