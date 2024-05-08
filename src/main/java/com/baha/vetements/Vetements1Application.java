package com.baha.vetements;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.baha.vetements.entities.Vetement;
import com.baha.vetements.service.VetementService;

@SpringBootApplication
public class Vetements1Application implements CommandLineRunner{
	
	@Autowired
	VetementService vetementService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(Vetements1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Vetement.class);

	}

}
