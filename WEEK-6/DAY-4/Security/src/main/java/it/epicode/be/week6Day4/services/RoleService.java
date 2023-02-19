package it.epicode.be.week6Day4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.epicode.be.week6Day4.models.Role;
import it.epicode.be.week6Day4.models.User;
import it.epicode.be.week6Day4.repositories.RoleRepository;
import it.epicode.be.week6Day4.repositories.UserRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository rRepo;
	
	public Role save(Role role) {
		return rRepo.save(role);
	}

}
