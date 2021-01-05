package com.portfolio.dsdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(enableDefaultTransactions = false)
@SpringBootApplication
public class DsdeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsdeliveryApplication.class, args);
	}

}
