package com.revature.FurnitureCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Specifies the base package to scan for Spring components (controllers, services, repositories, etc.)
@ComponentScan("com.revature")
// Specifies the base package to scan for JPA entity classes
@EntityScan("com.revature.Models")
// Enables JPA repositories and specifies the base package to scan for repository interfaces
@EnableJpaRepositories("com.revature.Repos")
public class FurnitureCollectionApplication {
	// The main method, which starts the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(FurnitureCollectionApplication.class, args);
	}
}
