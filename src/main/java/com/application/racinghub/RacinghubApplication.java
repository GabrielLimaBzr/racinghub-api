package com.application.racinghub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RacinghubApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacinghubApplication.class, args);
	}

}
