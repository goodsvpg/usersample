package com.example.usersample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UsersampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersampleApplication.class, args);
	}

}
