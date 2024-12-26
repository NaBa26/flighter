package com.example.flighter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.example.flighter.entity")
@EnableJpaRepositories("com.example.flighter.repository")
@EnableTransactionManagement
public class FlighterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlighterApplication.class, args);
	}

}
