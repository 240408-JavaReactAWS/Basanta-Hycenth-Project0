package com.revature.FurnitureCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.revature")
@EntityScan("com.revature.Models")
@EnableJpaRepositories("com.revature.Repos")
public class FurnitureCollectionApplication {
	public static void main(String[] args) {
		SpringApplication.run(FurnitureCollectionApplication.class, args);
	}

}
