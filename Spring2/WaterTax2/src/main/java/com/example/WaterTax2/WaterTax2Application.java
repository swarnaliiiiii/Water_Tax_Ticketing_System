package com.example.WaterTax2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WaterTax2Application {

	public static void main(String[] args) {
		SpringApplication.run(WaterTax2Application.class, args);
	}
}

