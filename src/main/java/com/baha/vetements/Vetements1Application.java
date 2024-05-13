package com.baha.vetements;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.baha.vetements.entities.Role;
import com.baha.vetements.entities.User;
import com.baha.vetements.entities.Vetement;
import com.baha.vetements.service.UserService;
import com.baha.vetements.service.VetementService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Vetements1Application implements CommandLineRunner{
	
	@Autowired
	VetementService vetementService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(Vetements1Application.class, args);
	}

	/***
	@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"baha","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("baha", "USER");
	userService.addRoleToUser("baha", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}
	
	**/
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));
		repositoryRestConfiguration.exposeIdsFor(Vetement.class);

	}

}
