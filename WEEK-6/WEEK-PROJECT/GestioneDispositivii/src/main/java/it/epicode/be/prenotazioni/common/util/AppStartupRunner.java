package it.epicode.be.prenotazioni.common.util;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import it.epicode.be.prenotazioni.model.Role;
import it.epicode.be.prenotazioni.model.RoleType;
import it.epicode.be.prenotazioni.model.User;
import it.epicode.be.prenotazioni.repository.RoleRepository;
import it.epicode.be.prenotazioni.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppStartupRunner implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public boolean ok = true;

	@Override
	public void run(String... args) throws Exception {
		if (ok) {
			List<Role> role = initRole();
			User user = initUser(role);
		}
	}

	private List<Role> initRole() {
		List<Role> result = new ArrayList<Role>();
		Role role = new Role();
		role.setRoleType(RoleType.ROLE_ADMIN);
		roleRepository.save(role);
		result.add(role);
		log.info("Saved Role: {}", role.getRoleType());

		role = new Role();
		role.setRoleType(RoleType.ROLE_USER);
		roleRepository.save(role);
		result.add(role);

		log.info("Saved Role: {}", role.getRoleType());

		return result;
	}

	private User initUser(List<Role> roles) {
		User user = new User();
		user.setUsername("cosimo");
		user.setNome("Cosimo");
		user.setCognome("Gargiullo");
		user.setEmail("cosimo@gmail.com");
		user.setPassword("test");
		user.setRoles(new HashSet<Role>(roles));
		userRepository.save(user);

		log.info("Saved User: {}", user.getNome());

		return user;
	}
}