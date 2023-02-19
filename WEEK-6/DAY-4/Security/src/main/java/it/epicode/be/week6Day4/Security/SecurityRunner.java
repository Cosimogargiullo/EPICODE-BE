package it.epicode.be.week6Day4.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.epicode.be.week6Day4.models.Role;
import it.epicode.be.week6Day4.models.RoleType;
import it.epicode.be.week6Day4.models.User;
import it.epicode.be.week6Day4.services.RoleService;
import it.epicode.be.week6Day4.services.UserService;

@SpringBootApplication
public class SecurityRunner implements CommandLineRunner{

	@Autowired
	public UserService uService;
	
	@Autowired
	public RoleService rService;
	
	@Override
	public void run(String... args) throws Exception {

		Role user = new Role().builder().type(RoleType.USER).build();
		Role admin = new Role().builder().type(RoleType.ADMIN).build();
		
		rService.save(admin);
		rService.save(user);
		
		
		uService.save(new User("Cosimo", true, "cosimoUser", "password", admin));
		uService.save(new User("Laura", true, "lauraUser", "password", admin));
		uService.save(new User("Stefano", true, "stefanoUser", "password", user));
		uService.save(new User("Alessia", false, "alessiaUser", "password", user));
		
		
	}

}
