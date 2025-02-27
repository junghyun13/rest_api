package com.li.rest2501;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Rest2501Application {

	public static void main(String[] args) {
		SpringApplication.run(Rest2501Application.class, args);
	}

}
