package it.epicode.mobilemonitoring.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.gestione.dispositivi.models.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUsername(String username);

}
