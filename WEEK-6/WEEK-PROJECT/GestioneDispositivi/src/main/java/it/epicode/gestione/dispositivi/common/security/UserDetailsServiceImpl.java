package it.epicode.gestione.dispositivi.common.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.epicode.gestione.dispositivi.models.User;
import it.epicode.gestione.dispositivi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository epicodeUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> loadUserByUsername = epicodeUserRepository.findByUsername(username);
		if ( loadUserByUsername.isPresent()) {
			return UserDetailsImpl.build(loadUserByUsername.get());
		} else {
			throw new UsernameNotFoundException("Utente non trovato: " + username);
		}
	}
}
