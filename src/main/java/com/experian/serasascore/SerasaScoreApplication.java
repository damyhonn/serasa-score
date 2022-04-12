package com.experian.serasascore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SerasaScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerasaScoreApplication.class, args);
	}

}
