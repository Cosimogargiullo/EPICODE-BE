package it.epicode.be.week6Day4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.epicode.be.week6Day4.models.User;
import it.epicode.be.week6Day4.repositories.UserRepository;

@Service
@Component
public class UserService {

	@Autowired
	private UserRepository uRepo;
	
	public User save(User user) {
		return uRepo.save(user);
	}

}
