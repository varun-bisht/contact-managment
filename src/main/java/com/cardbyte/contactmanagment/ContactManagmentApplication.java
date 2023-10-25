package com.cardbyte.contactmanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ContactManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagmentApplication.class, args);
	}

}
