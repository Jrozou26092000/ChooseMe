package com.chooseme.proyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.chooseme.proyect.entities.Users;
import com.chooseme.proyect.repository.UsersRepository;

@Configuration
@SpringBootApplication
public class ChoosemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChoosemeApplication.class, args);
		
	}

}
